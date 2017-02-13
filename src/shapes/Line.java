package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends Shape {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private float k;
	
	public Line(int x1, int y1, int x2, int y2, float thick)
	{
		super(thick);
		this.x1 = x1; this.y1 = y1;
		this.x2 = x2; this.y2 = y2;
		if(x1 != x2)
			k = (float)(y2-y1)/(x2-x1);
	}
	
	@Override
	public void big() {
		if(x1<x2){
			x2++;
			y2 = (int)(k*(x2-x1)+y1);
		}
		else{
			x2--;
			y2 = (int)(k*(x2-x1)+y1);
		}
	}

	@Override
	public void small() {
		if(x1<x2){
			x2--;
			y2 = (int)(k*(x2-x1)+y1);
		}
		else{
			x2++;
			y2 = (int)(k*(x2-x1)+y1);
		}
	}

	@Override
	public void relocate(int delx, int dely) {
		this.x1 += delx;
		this.x2 += delx;
		this.y1 += dely;
		this.y2 += dely;
	}
	
	@Override
	public boolean contains(int x, int y) {
		if(x>=Math.min(x1, x2) && x<=Math.max(x1, x2))
			if(y>=Math.min(y1, y2) && y<=Math.max(y1, y2)){
				float t1 = (float)(x-x1)/(x2-x1);
				float t2 = (float)(y-y1)/(y2-y1);
				if(Math.abs(t1-t2) <= 0.3)
					return true;
			}
		return false;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(thick));
		g.drawLine(x1, y1, x2, y2);
	}

}
