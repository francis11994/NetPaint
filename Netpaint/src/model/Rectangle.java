package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends PaintObject{

	
	public Rectangle(Point initial, Point lastPoint, Color color) {
		super(initial, lastPoint, color);
		
	}

	@Override
	public void paint(Graphics g){
		g.setColor(getColor().RED);
		g.fillRect((int) getInitial().getX(), (int) getInitial().getY(), (int) getLastPoint().getX(), (int) getLastPoint().getY());
	}
}
