package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageFile extends PaintObject{

	private Image dog;
	
	public imageFile(Point initial, Color color) {
		super(initial, color);
		try{
				dog = ImageIO.read(new File("./picture/doge.jpeg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
	@Override
	public void paint(Graphics g) {
		g.setColor(getColor());
		int iX=(int) getInitial().getX();
		int iY=(int) getInitial().getY();
		int fX=(int) getLastPoint().getX();
		int fY=(int) getLastPoint().getY();
		int width=Math.abs((int) (fX-iX));
		int length=Math.abs((int) ( fY-iY));
		g.drawImage(dog, Math.min(iX,fX ), Math.min(iY, fY), width, length, null);
	}

}
