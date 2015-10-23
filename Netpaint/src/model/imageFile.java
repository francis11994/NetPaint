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
	
	public imageFile(Point initial, Point lastPoint, Color color) {
		super(initial, lastPoint, color);
		try{
				dog = ImageIO.read(new File("./picture/dog.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(dog, (int) getInitial().getX(), (int) getInitial().getY(), (int) getLastPoint().getX(), (int) getLastPoint().getY(), null);
	}

}
