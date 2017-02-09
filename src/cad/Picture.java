package cad;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Picture extends JFrame {
	private static final long serialVersionUID = 1L;//����ID
	private int width;
	private int height;
	
	private ArrayList<Shape> listShape = new ArrayList<Shape>();//Ҫ����ͼ��
	
	private class ShapesPanel extends JPanel {//�̳�JPanel
		private static final long serialVersionUID = 1L;//����ID

		@Override
		protected void paintComponent(Graphics g) {//��д������ͼ���б�����
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
		setVisible(true);//�Զ�����paintComponent����
	}
}
