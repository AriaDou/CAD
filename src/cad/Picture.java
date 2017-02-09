package cad;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Picture extends JFrame {
	private static final long serialVersionUID = 1L;//设置ID
	private int width;
	private int height;
	
	private ArrayList<Shape> listShape = new ArrayList<Shape>();//要画的图像
	
	private class ShapesPanel extends JPanel {//继承JPanel
		private static final long serialVersionUID = 1L;//设置ID

		@Override
		protected void paintComponent(Graphics g) {//重写：遍历图像列表画部件
			super.paintComponent(g);
			for ( Shape s : listShape )
			{
				s.draw(g);
			}			
		}
		
	}
	
	public void add(Shape s)
	{
		listShape.add(s);
	}

	public Picture(int width, int height)
	{
		add(new ShapesPanel());
		this.width = width;
		this.height = height;
	}
	
	public void draw()
	{
		setLocationRelativeTo(null);
		setSize(width, height);
		setVisible(true);//自动调用paintComponent函数
	}
}
