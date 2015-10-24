package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends PaintObject{

		
	public Line(Point initial, Point lastPoint, Color color) {
		super(initial, lastPoint, color);
		
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(getColor().GREEN);
		g.drawLine((int) getInitial().getX(), (int) getInitial().getY(), (int) getLastPoint().getX(), (int) getLastPoint().getY());
	}
}
