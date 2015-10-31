package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Line extends PaintObject implements Serializable{

		
	public Line(Point initial, Color color) {
		super(initial, color);
		
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(getColor());
		int iX=(int) getInitial().getX();
		int iY=(int) getInitial().getY();
		int fX=(int) getLastPoint().getX();
		int fY=(int) getLastPoint().getY();
		g.drawLine(iX, iY,fX,fY);
		}

	
}
