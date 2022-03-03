package Painting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

public class DrawBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7739922099507251217L;

	public Color c = Color.black;// 设置背景默认颜色，黑色
	public JButton bt;// 按钮属性
	public JPanel panelcenter;
	public Graphics2D g;

	ArrayList<Object> list = new ArrayList<Object>();

	public void initFrame() {
		this.setSize(600, 500);
		this.setTitle("My Paint");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		addMenu();// 封装起来

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.add(panel);

		// JMenuBar bar = new JMenuBar();
		// panel.add(bar, BorderLayout.NORTH);
		// String[] str = { "File", "View", "Help", "Search" };
		// String[] str1 = { "Open file", "View file", "Help", "Search" };
		// for (int i = 0; i < 4; i++) {
		// JMenu menu = new JMenu(str[i]);
		// for (int j = 0; j < 4; j++) {
		// JMenuItem item = new JMenuItem(str[j]);
		// menu.add(item);
		// }
		// bar.add(menu);
		// }

		panelcenter = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3929419791850630204L;

			public void paint(Graphics g1) {
				Graphics2D g = (Graphics2D) g1;
				super.paint(g);
				for (int i = 0; i < list.size(); i++) {
					Shape shape = (Shape) list.get(i);
					shape.Draw(g);
				}
			}
		};
		panelcenter.setBackground(Color.white);
		panel.add(panelcenter);

		// JPanel panelcenterchild = new JPanel();
		// public void paint(Gra)

		JPanel panelLeft = new JPanel();
		panelLeft.setPreferredSize(new Dimension(50, 0));
		panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelLeft.setBackground(new Color(235, 233, 238));
		panel.add(panelLeft, BorderLayout.WEST);

		ButtonGroup bg = new ButtonGroup();
		for (int i = 1; i <= 16; i++) {
			JRadioButton jrb = new JRadioButton();
			int width = 25, height = 25;

			ImageIcon img1 = new ImageIcon("D:/Git 项目/DrawBoard/src/logo/" + i + ".gif");
			// ImageIcon img2 = new
			// ImageIcon("//Users/Heavy/eclipse-workspace/DrawBoard/src/logo/" + i +
			// ".gif");
			// ImageIcon img3 = new
			// ImageIcon("//Users/Heavy/eclipse-workspace/DrawBoard/src/logo/" + i +
			// ".gif");
			// ImageIcon img4 = new
			// ImageIcon("//Users/Heavy/eclipse-workspace/DrawBoard/src/logo/" + i +
			// ".gif");

			Image img = img1.getImage();
			img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // 更改图标大小，是否有更好的方法？
			img1.setImage(img);

			jrb.setIcon(img1);
			// jrb.setRolloverIcon(img2);
			// jrb.setPressedIcon(img3);
			// jrb.setSelectedIcon(img4);
			jrb.setBorder(null);
			if (i == 10) {
				jrb.setSelected(true);
			}
			jrb.setActionCommand("pic" + i);

			bg.add(jrb);
			panelLeft.add(jrb);
		}

		JPanel panelDown = new JPanel();
		panelDown.setPreferredSize(new Dimension(0, 60));
		panelDown.setLayout(null);
		panelDown.setBackground(Color.gray);
		panel.add(panelDown, BorderLayout.SOUTH);

		JPanel panelDownchild = new JPanel();
		panelDownchild.setBackground(Color.cyan);
		panelDownchild.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelDownchild.setBounds(10, 10, 280, 40);
		panelDown.add(panelDownchild);

		BevelBorder bb0 = new BevelBorder(0, Color.gray, Color.white);
		BevelBorder bb1 = new BevelBorder(1, Color.gray, Color.white);

		JPanel left = new JPanel();
		left.setBackground(Color.white);
		left.setLayout(null);
		left.setBorder(bb0);
		left.setPreferredSize(new Dimension(40, 40));

		bt = new JButton();
		bt.setBounds(5, 5, 20, 20);
		bt.setBorder(bb1);
		bt.setBackground(Color.black);
		bt.setOpaque(true);
		// bt.setBorderPainted(false);
		bt.setSize(20, 20);

		JButton bt1 = new JButton();
		bt1.setBorder(bb1);
		bt1.setBounds(15, 15, 20, 20);
		left.add(bt);
		left.add(bt1);

		JPanel right = new JPanel();
		right.setBackground(Color.white);
		right.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		right.setPreferredSize(new Dimension(240, 40));

		panelDownchild.add(left);
		panelDownchild.add(right);

		ButtonListener bl = new ButtonListener(this);// 增加这条语句，给右面板按钮增加监听器
		// 调色板按钮背景颜色，未来重绘部分，最终写一个rgb调色板；
		Color[] colors = { new Color(0, 0, 0), new Color(47, 78, 78), new Color(0, 128, 128), new Color(128, 128, 128),
				new Color(178, 34, 34), new Color(220, 20, 60), new Color(255, 20, 142), new Color(152, 50, 204),
				new Color(216, 191, 216), new Color(240, 138, 138), new Color(255, 248, 220), new Color(135, 206, 235),
				new Color(255, 255, 255), new Color(225, 255, 250), new Color(72, 81, 139), new Color(123, 104, 238),
				new Color(134, 208, 204), new Color(144, 238, 144), new Color(127, 255, 0), new Color(0, 255, 127),
				new Color(0, 250, 154), new Color(255, 255, 0), new Color(240, 230, 140), new Color(255, 250, 205)
		};

		for (int i = 0; i < 24; i++) {
			JButton bt2 = new JButton();
			// Color c = new Color(i * 10, i * 5 + 30, 255 - i * 7);
			bt2.setBackground(colors[i]);
			bt2.setOpaque(true);
			bt2.setPreferredSize(new Dimension(20, 20));
			bt2.setBorder(bb0);
			// bt2.setBorderPainted(false); //关于图层的覆盖？
			bt2.addActionListener(bl);
			right.add(bt2);
		}
		this.setVisible(true);

		Graphics g = panelcenter.getGraphics();

		DrawListener dl = new DrawListener(g, bg, this, list);// 构造函数的使用顺序,this的引用调用
		panelcenter.addMouseListener(dl);
		panelcenter.addMouseMotionListener(dl);
	}

	public void addMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		ItemListener il = new ItemListener(this);

		JMenuItem item0 = new JMenuItem("New");
		JMenuItem item1 = new JMenuItem("Open");
		JMenuItem item2 = new JMenuItem("Save");

		item0.addActionListener(il);
		item1.addActionListener(il);
		item2.addActionListener(il);

		this.setJMenuBar(bar);
		bar.add(menu);

		menu.add(item0);
		menu.add(item1);
		menu.add(item2);
	}
}
