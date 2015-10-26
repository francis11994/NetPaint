package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DrawList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627563815191537172L;
	private ArrayList<PaintObject> list;
	public DrawList(){
		list=new ArrayList<PaintObject>();
	}
	public void add(PaintObject e){
		list.add(e);
	}
	
	public ArrayList<PaintObject> getlist(){
		return list;
	}
}
