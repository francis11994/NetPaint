package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public abstract class PaintObject{

	
	private Point initial = new Point(0,0);
	private Point lastPoint = new Point(0,0);
	private Color color;
	
	public PaintObject(Point initial, Color color){
		this.initial = initial;
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
	public void setfinalpoint(Point a){
		lastPoint=a;
	}
	public abstract void paint(Graphics g);
}
