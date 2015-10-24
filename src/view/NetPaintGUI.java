package view;
//programmer
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
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import model.PaintObject;

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
	private String selected=" ";
	private ArrayList<PaintObject> list;
	private boolean drawing;
	private PaintObject paint;
	private Color color=Color.black;
	private JPanel canvas=new DrawingPanel();
	private addlistener listener=new addlistener();
	public NetPaintGUI(){
		layoutTheJFrame();
		addlistener();
		setlist();
	}
	public void setlist(){
		PaintObject e=new model.Circle(new Point(450,200),Color.BLUE);
		e.setfinalpoint(new Point(650,400));
		list.add(e);
		PaintObject d=new model.Rectangle(new Point(150,200),Color.RED);
		d.setfinalpoint(new Point(400,400));
		list.add(d);
		PaintObject a=new model.Line(new Point(222,300),Color.GREEN);
		a.setfinalpoint(new Point(555,350));
		list.add(a);
		PaintObject b=new model.Line(new Point(202,400),Color.GREEN);
		b.setfinalpoint(new Point(500,300));
		list.add(b);
		PaintObject c=new model.imageFile(new Point(50,50), color);
		c.setfinalpoint(new Point(300,300));
		list.add(c);
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
		//label.add(choosecolor);
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
	}
	public class addlistener implements ActionListener,MouseListener,MouseMotionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!drawing)
			selected=((JRadioButton) e.getSource()).getText();
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
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

	private class DrawingPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public DrawingPanel(){
			setBackground(Color.WHITE);
			setLayout(null);
			setPreferredSize(new Dimension(2000,2000));
			drawing=false;
			list=new ArrayList<PaintObject>();
			addMouseMotionListener(listener);
			addMouseListener(listener);
			
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			for(PaintObject paint: list)
				paint.paint(g);
		}
	}
	
	
	
	
}
