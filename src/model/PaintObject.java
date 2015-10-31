package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;

import javax.swing.JPanel;

public abstract class PaintObject implements Serializable{

	
	private Point initial = new Point(0,0);
	private Point lastPoint = new Point(0,0);
	private Color color;
	private boolean canpaint;
	
	public PaintObject(Point initial, Color color){
		this.initial = initial;
		this.color = color;
		canpaint=false;
	}
	public void setcolor(Color a){
		color=a;
	}
	public void setfinalpoint(Point a){
		lastPoint=a;
		canpaint=true;
	}
	public boolean canpaint(){
		return canpaint;
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
