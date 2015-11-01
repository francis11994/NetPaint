package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;

public class imageFile extends PaintObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public imageFile(Point initial, Color color) {
		super(initial, color);
			
	}

	@Override
	public void paint(Graphics g,Image b) {
		g.setColor(getColor());
		int iX=(int) getInitial().getX();
		int iY=(int) getInitial().getY();
		int fX=(int) getLastPoint().getX();
		int fY=(int) getLastPoint().getY();	
		g.drawImage(b, iX, iY, (int) (fX-iX), (int) ( fY-iY), null);

	}


}
