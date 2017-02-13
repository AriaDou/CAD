package shapes;

import java.awt.Font;
import java.awt.Graphics2D;

import shapes.Shape;

public class Word extends Shape {
	private String str;
	private int x;
	private int y;
	private int size;

	public Word(String str, int x1, int y1, int x2, int y2) {
		super(0f);
		this.str = str;
		x = Math.min(x1, x2);
		this.size = Math.abs(x2-x1)/2;
		if(y1<y2)
			y = y1 + size;
		else y = y1;
	}

	@Override
	public void big() {
		size++;
	}

	@Override
	public void small() {
		if(size>1)
			size--;
	}

	@Override
	public void relocate(int delx, int dely) {
		this.x += delx;
		this.y += dely;
	}

	@Override
	public boolean contains(int x, int y) {
		if(x>=this.x && x<=this.x+Math.abs(size))
			if(y>=this.y-Math.abs(size) && y<=this.y)
				return true;
		return false;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setFont(new Font("ËÎÌו", 0, size));
		g.drawString(str, x, y);
	}
}
