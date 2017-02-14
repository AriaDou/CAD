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
	public void setColor(Color color) {//设置颜色
		this.color = color;
	}
	public void upThick() {//变粗
		thick++;
	}
	public void downThick() {//变细
		if(thick>0)
		thick--;
	}
	public abstract void big();//变大
	public abstract void small();//变小
	public abstract boolean contains(int x, int y);//该点是否包含于图像内
	public abstract void relocate(int delx, int dely);//
	public abstract void draw(Graphics2D g);
	
}
