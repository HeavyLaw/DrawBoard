package Painting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;


public class DrawListener implements MouseListener, MouseMotionListener {
	public Graphics2D g;
	public int x1, y1, x2, y2, old_x, old_y, x4, y4;
	public ButtonGroup bg;
	public String command;
	public ArrayList<Object> list;
	
	public boolean flag = true;
	public DrawBoard db;
	public Color color;

	/*public static final Stroke s1 = new BasicStroke(1);
	public static final Stroke s2 = new BasicStroke(10);
	public static final Stroke s3 = new BasicStroke(15);
	

	//DrawListener rewrite
	public DrawListener(Graphics g, ButtonGroup bg, 
			DrawBoard drawboard_1, ArrayList list){
		
		this.g = (Graphics2D) g;k
		this.bg= bg;
		this.db = drawboard_1;
		this.list = list;
	} */ 
	public Random r = new Random();
	
	public DrawListener(Graphics g1) {
		g = (Graphics2D) g1;
	}
	
	public DrawListener(Graphics g2, ButtonGroup bg1) {
		g = (Graphics2D) g2;
		bg = bg1;
	}
	
	public DrawListener(Graphics g3, ButtonGroup bg2, DrawBoard db1, ArrayList<Object> list) {
		g = (Graphics2D) g3;
		bg = bg2;
		db = db1;
		this.list = list;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int count = e.getClickCount();
		if(count == 2 && "pic14".equals(command)) {
			Shape line = new Line(old_x, old_y, x2, y2, g.getColor(), 1);
			line.Draw(g);
			list.add(line);
			
			flag = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		color = db.c;
		g.setColor(color);
		g.setStroke(new BasicStroke(1));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		
		ButtonModel bm = bg.getSelection();//return your selected button model
		command = bm.getActionCommand();//get your selected button name
		
		
		//color = db.c;
		//g.setColor(color);
		
	}
		/*Stroke s1 = new BasicStroke(1);
		g.setStroke(s1);
		
		}/*else if("pic13".equals(command)){
			if(flag){
				g.drawLine(x1, y1, x2, y2);
				Line line = new Line(x1, y1, x2, y2, 
						g.getColor(), g.getStroke());
				list.add(line);
				flag = false;
				x4 = x1;
				y4 = y1;
			}
			else{
				g.drawLine(old_x, old_y, x2, y2);
				Line line = new Line(old_x, old_y, x2, y2, 
						g.getColor(), g.getStroke());
				list.add(line);
			}
			
			old_x = x2;
			old_y = y2;
		}*/
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		//g.drawLine(x1, y1, x2, y2);
		if("pic11".equals(command)){
			Shape line = new Line(x1, y1, x2, y2, g.getColor(), 1);
			line.Draw(g);
			list.add(line);
		}else if("pic13".equals(command)){
			Shape rect = new Rect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), g.getColor(), 1);
			rect.Draw(g);
			list.add(rect);
		}else if("pic15".equals(command)){
			Shape oval = new Oval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), g.getColor(), 1);
			oval.Draw(g);
			list.add(oval);
		}else if("pic16".equals(command)){
			Shape rrect = new RoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), 40, 40, g.getColor(), 1);
			rrect.Draw(g);
			list.add(rrect);
		}else if("pic14".equals(command)){
			if(flag){
				Shape line = new Line(x1, y1, x2, y2, g.getColor(), 1);
				line.Draw(g);
				list.add(line);
				flag = false;
				
				x4 = x2;
				y4 = y2;
				
				old_x = x1;
				old_y = y1;
			}
			else{
				Shape line = new Line(x4, y4, x2, y2, g.getColor(), 1);
				line.Draw(g);
				list.add(line);
				
				x4 = x2;
				y4 = y2;
			}
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		if("pic7".equals(command)) {
			
			Shape line = new Line(x1, y1, x, y, g.getColor(), 1);
			line.Draw(g);
			list.add(line);
			
			x1 = x;
			y1 = y;
		}else if("pic3".equals(command)) {
			g.setColor(Color.white);
			Shape line = new Line(x1, y1, x, y, g.getColor(), 15);
			line.Draw(g);
			list.add(line);
			
			x1 = x;
			y1 = y;
		}else if("pic8".equals(command)) {
			
			Shape line = new Line(x1, y1, x, y, g.getColor(), 10);
			line.Draw(g);
			list.add(line);
			
			x1 = x;
			y1 = y;
		}else if("pic9".equals(command)) {
			for(int i = 0; i < 30; i++) {
				int xp = r.nextInt(31) - 15;
				int yp = r.nextInt(31) - 15;
				g.drawLine(x + xp, y + yp, x + xp, y + yp);
				
				Point point = new Point(x + xp, y + yp, g.getColor(), g.getStroke());
				list.add(point);
			}
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
