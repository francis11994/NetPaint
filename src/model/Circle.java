package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;


public class Circle extends PaintObject implements Serializable{

	
	public Circle(Point initial, Color color) {
		super(initial, color);	
	}

	@Override
	public void paint(Graphics g){
		g.setColor(getColor());
		int iX=(int) getInitial().getX();
		int iY=(int) getInitial().getY();
		int fX=(int) getLastPoint().getX();
		int fY=(int) getLastPoint().getY();
		int width=Math.abs((int) (fX-iX));
		int length=Math.abs((int) (fY-iY));
		g.fillOval(Math.min(iX,fX ), Math.min(iY, fY), width, length);
		}

	@Override
	public String shap() {
		return "Circle";
	}

	
	
}
