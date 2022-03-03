package Painting;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3725995340735848676L;
	
	public int x1, y1, x2, y2;
	public Color color;
	public int width;
	
	public abstract void Draw(Graphics2D g);

}
