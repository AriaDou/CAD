package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x1, int y1, int x2, int y2, float thick) {
		super(thick);
		x = Math.min(x1, x2);
		y = Math.min(y1, y2);
		this.width = Math.abs(x2-x1);
		this.height = Math.abs(y2-y1);
	}

	@Override
	public void big() {
		width++;
		height++;
	}

	@Override
	public void small() {
		if(width>1 && height>1){
			width--;
			height--;
		}
	}

	@Override
	public void relocate(int delx, int dely) {
		this.x += delx;
		this.y += dely;
	}

	@Override
	public boolean contains(int x, int y) {
		if(x>=this.x && x<=this.x+width)
			if(y>=this.y && y<=this.y+height)
				return true;
		return false;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(thick));
		g.drawRect(x, y, width, height);
	}

}
