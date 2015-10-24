package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import model.Circle;
import model.PaintObject;

public class PaintObjectGUI extends JFrame {
	public static void main(String[] args) {
		new PaintObjectGUI().setVisible(true);
	}
	private JScrollPane panel=new JScrollPane();
	private JPanel canvas=new JPanel();
	private JPanel label=new JPanel();
	private JRadioButton Line=new JRadioButton("Line");
	private JRadioButton Oval=new JRadioButton("Oval");
	private JRadioButton Rectangle=new JRadioButton("Rectangle");
	private JButton choosecolor=new JButton("Choose Color");
	private JRadioButton Image=new JRadioButton("Image");
	private ButtonGroup buttons=new ButtonGroup();
	private ArrayList<PaintObject> arry;
	private PaintObject obj;
	private Point lin = new Point(300, 200);
	private Point rec = new Point(400, 400);
	private	Point cir = new Point(500, 500);
	private	Point ima = new Point(460, 450);
	private Color color;
	private Graphics g;
	public PaintObjectGUI(){
		layoutTheJFrame();
		
	}

	public void layoutTheJFrame(){
		
		//Jframe
		setSize(760, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JScrollPane
		canvas.setBackground(Color.WHITE);
		panel.getViewport().add(canvas);
		canvas.setPreferredSize(new Dimension(2048,1024));
		
		//add shapes to arrayList<PaintObject>
		arry = new ArrayList<PaintObject>();
		obj = new Circle(lin, rec, color.RED);
		arry.add(obj);
		obj = new Circle(lin, rec, color.GREEN);
		arry.add(obj);
		drawShapesOnMe(g, arry);
		//choices
		label.setLayout(new FlowLayout());
		label.add(choosecolor);
		label.add(Line);
		label.add(Image);
		label.add(Oval);
		label.add(Rectangle);
		buttons.add(Line);
		buttons.add(Oval);
		buttons.add(Rectangle);
		buttons.add(Image);
		add(panel,BorderLayout.CENTER);
		add(label,BorderLayout.SOUTH);
	}
	
	 private void drawShapesOnMe(Graphics g, ArrayList<PaintObject> shapes) {
		 shapes.get(0);
		 shapes.get(1);
	 }
	
}
