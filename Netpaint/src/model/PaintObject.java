package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public abstract class PaintObject{

	
	private Point initial = new Point(0,0);
	private Point lastPoint = new Point(0,0);
	private Color color;
	
	public PaintObject(Point initial, Point lastPoint, Color color){
		this.initial = initial;
		this.lastPoint = lastPoint;
		this.color = color;
	}
	public Point getInitial(){
		return initial;
	}
	public Point getLastPoint(){
		return lastPoint;
	}
	public Color getColor(){
		return color;
	}
	public abstract void paint(Graphics g);
}
