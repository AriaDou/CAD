package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Shape implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Color color = Color.BLACK;
	protected float thick;
	
	public Shape(float thick) {
		this.thick = thick;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void upThick() {
		thick++;
	}
	public void downThick() {
		if(thick>0)
		thick--;
	}
	public abstract void big();
	public abstract void small();
	public abstract boolean contains(int x, int y);
	public abstract void relocate(int delx, int dely);
	public abstract void draw(Graphics2D g);
	
}
