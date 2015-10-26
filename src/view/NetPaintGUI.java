package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import model.Circle;
import model.DrawList;
import model.PaintObject;
import model.imageFile;
//Part 2 complete
public class NetPaintGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new NetPaintGUI().setVisible(true);
	}
	private JScrollPane panel=new JScrollPane();
	private JPanel label=new JPanel();
	private JRadioButton Line=new JRadioButton("Line"), Oval=new JRadioButton("Oval"), Rectangle=new JRadioButton("Rectangle"), Image=new JRadioButton("Image");
	private JButton choosecolor=new JButton("Choose Color");
	private ButtonGroup buttons=new ButtonGroup();
	private boolean drawing;
	private String selected=" ";
	private JPanel canvas=new DrawingPanel();
	private addlistener listener=new addlistener();
	private DrawList list=new DrawList();
	private PaintObject paint;
	private Color color=Color.black;
	private JColorChooser colorpanel=new JColorChooser(color);
	public NetPaintGUI(){
		layoutTheJFrame();
		addlistener();
	}

	public void layoutTheJFrame(){
		
		//Jframe
		setSize(760, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JScrollPane
		panel.getViewport().add(canvas);
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
	public void addlistener(){
		Line.addActionListener(listener);
		Oval.addActionListener(listener);
		Image.addActionListener(listener);
		Rectangle.addActionListener(listener);
		panel.addMouseMotionListener(listener);
		panel.addMouseListener(listener);
		choosecolor.addActionListener(new colorlistener());
	}
	public class addlistener implements ActionListener,MouseListener,MouseMotionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!drawing)
				selected= ((JRadioButton) e.getSource()).getText();	
		}

		@Override
		public void mouseDragged(MouseEvent e) {
	
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(drawing){
				Point original=panel.getViewport().getViewPosition();
				Point point=e.getPoint();
				point=new Point((int)(original.getX()+point.getX()) ,(int)(original.getY()+point.getY()));
				paint.setfinalpoint(point);
				repaint();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(!drawing){
				Point original=panel.getViewport().getViewPosition();
				Point point=e.getPoint();
				point=new Point((int)(original.getX()+point.getX()) ,(int)(original.getY()+point.getY()));
				if(!selected.equals(" "))
					drawing=true;
					color=colorpanel.getColor();
				if(selected.equals("Line"))
					paint=new model.Line(point, color);
				if(selected.equals("Oval"))
					paint=new model.Circle(point, color);
				if(selected.equals("Rectangle"))
					paint=new model.Rectangle(point, color);
				if(selected.equals("Image"))
					paint=new model.imageFile(point, color);
			}
			else {
				list.add(paint);
				repaint();
				drawing=false;
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public class colorlistener implements ActionListener{
		private JFrame colorPanel;
		public colorlistener(){
			colorPanel=new JFrame();
			colorPanel.setSize(500,300);
			colorPanel.setLocation(300,300);
			colorPanel.setTitle("Choose color");
			colorPanel.add(colorpanel);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			colorPanel.setVisible(true);	
		}
		
	}
	private class DrawingPanel extends JPanel{
		public DrawingPanel(){
			setBackground(Color.WHITE);
			setLayout(null);
			setPreferredSize(new Dimension(2000,2000));
			drawing=false;
			addMouseMotionListener(listener);
			addMouseListener(listener);
			
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			ArrayList<PaintObject> printlist=list.getlist();
			for(PaintObject a:printlist)
				a.paint(g);
			if(paint!=null)
			if(paint.canpaint())
			paint.paint(g);
		}
	}
		
}
