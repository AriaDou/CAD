package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Circle extends Shape {
	private int x;
	private int y;
	private int radius;
	
	public Circle(int x1, int y1, int x2, int y2, float thick)
	{
		super(thick);
		x = x1;
		y = y1;
		this.radius = (int)Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
	
	@Override
	public void big() {
		radius++;
	}

	@Override
	public void small() {
		if(radius > 1)
			radius--;
	}

	@Override
	public void relocate(int delx, int dely) {
		this.x += delx;
		this.y += dely;
	}

	@Override
	public boolean contains(int x, int y) {
		if((int)Math.sqrt(Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2)) <= radius)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(thick));
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
	}
}
