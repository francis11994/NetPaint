package model;

import java.io.Serializable;
import java.util.Vector;

public class DrawList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627563815191537172L;
	private Vector<PaintObject> list;
	public DrawList(){
		list=new Vector<PaintObject>();
	}
	public void add(PaintObject e){
		list.add(e);
	}
	
	public Vector<PaintObject> getlist(){
		return list;
	}
}
