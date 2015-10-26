package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageFile extends PaintObject{

	private BufferedImage dog=null;
	
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
		g.drawImage(dog, iX, iY, (int) (fX-iX), (int) ( fY-iY), null);

	}

}
