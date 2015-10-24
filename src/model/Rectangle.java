package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends PaintObject{

	
	public Rectangle(Point initial, Color color) {
		super(initial,color);
		
	}

	@Override
	public void paint(Graphics g){
		g.setColor(getColor());
		int iX=(int) getInitial().getX();
		int iY=(int) getInitial().getY();
		int fX=(int) getLastPoint().getX();
		int fY=(int) getLastPoint().getY();
		int width=Math.abs((int) (getLastPoint().getX()-iX));
		int length=Math.abs((int) ( getLastPoint().getY()-iY));
		g.fillRect(Math.min(iX,fX ), Math.min(iY, fY), width, length);	}

}
