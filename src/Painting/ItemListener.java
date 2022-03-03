package Painting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ItemListener implements ActionListener {

	public DrawBoard paint;
	
	public ItemListener(DrawBoard paint) {
		this.paint = paint;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if("New".equals(command)) {
			
			int value = JOptionPane.showConfirmDialog(null, "Save changes?","Notice massager", 0);
			if(value == 0) {
				
				saveFile();
			}
			if(value == 1) {
				
				paint.list.removeAll(paint.list);
				paint.panelcenter.repaint();
			}
		}
		else if("Open".equals(command)){
			int value = JOptionPane.showConfirmDialog(null, "Save changes?","Notice massager", 0);
			if(value == 0) {
				
				saveFile();
			}
			if(value == 1) {
				
				paint.list.removeAll(paint.list);
				paint.panelcenter.repaint();
				
			try {
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File file = chooser.getSelectedFile();
					
					if(file == null) {
						JOptionPane.showConfirmDialog(null, "NO Files!");
					}else {
						FileInputStream fis = new FileInputStream(file);
						ObjectInputStream ois = new ObjectInputStream(fis);//存到父类中去
						@SuppressWarnings("unchecked")
						ArrayList<Shape> list = (ArrayList<Shape>) ois.readObject();
						for(int i = 0; i <list.size(); i++) {
							Shape shape = list.get(i);
							paint.list.add(shape);
							paint.panelcenter.repaint();
						}
						ois.close();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}else if("Save".equals(command)){
			
			saveFile();
		}
		
	}

	public void saveFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		
		//File file = new File("test");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(paint.list);
			JOptionPane.showMessageDialog(null, "Save successfully!");
			oos.close();
			}catch(Exception e1){
				e1.printStackTrace();
		}	
	}
	
}
