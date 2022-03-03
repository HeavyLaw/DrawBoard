package Painting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener{
	
	public DrawBoard db;
	
	public ButtonListener(DrawBoard db1) {
		db = db1;
	}
	public void actionPerformed(ActionEvent e) {
		
		JButton bt = (JButton) e.getSource();//???
		Color c = bt.getBackground();
		db.c = c;
		db.bt.setBackground(c);
		
	}
	

}
