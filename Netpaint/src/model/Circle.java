package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import view.PaintObjectGUI;

public class Circle extends PaintObject{

	
	public Circle(Point initial, Point lastPoint, Color color) {
		super(initial, lastPoint, color);	
	}

	@Override
	public void paint(Graphics g){
		g.setColor(getColor().RED);
		g.fillOval((int) getInitial().getX(), (int) getInitial().getY(), (int) getLastPoint().getX(), (int) getLastPoint().getY());
	}
	
}
