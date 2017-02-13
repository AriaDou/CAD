package cad;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Word;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6823162012684778136L;
	private static Shape currentShape;
	private boolean isAdd = true;
	private int currentNum = 0;
	private float thick = 3.0f;
	private int x1, x2, y1, y2;
	private ArrayList<Shape> listShape = new ArrayList<Shape>();//要画的图像
	
	public DrawPanel() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				requestFocus(true);
				x1 = e.getX();
				y1 = e.getY();
				for ( Shape s : listShape )
				{
					if(s.contains(x1, y1)){
						currentNum = listShape.indexOf(s);
						isAdd = false;
						break;
					}
					currentNum = listShape.size();
					isAdd = true;
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				if(currentNum < listShape.size() && isAdd == false){
					currentShape = listShape.remove(currentNum);
					currentShape.relocate(x2-x1, y2-y1);
					x1 = x2;
					y1 = y2;
					listShape.add(currentShape);
					currentNum = listShape.size()-1;
					repaint();
				}
				else addShapes();
			}
		});
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(currentNum < listShape.size()){
					currentShape = listShape.remove(currentNum);
					switch (keyChar) {
					case ',':
						currentShape.downThick();
						listShape.add(currentShape);
						repaint();
						break;
					case '.':
						currentShape.upThick();
						listShape.add(currentShape);
						repaint();
						break;
					case '+':
						currentShape.big();
						listShape.add(currentShape);
						break;
					case '-':
						currentShape.small();
						listShape.add(currentShape);
						break;
					case 'r':
						break;
					default:
						listShape.add(currentShape);
						break;
					}
					repaint();
					if(listShape.isEmpty())
						currentNum = 0;
					else
						currentNum = listShape.size() - 1;
				}
			}
		});
	}
	
	public void addShapes() {
		if(currentNum < listShape.size())
			listShape.remove(currentNum);
		switch (ToolsPanel.getCurrentButton()) {
		case "直线":
			listShape.add(currentNum, new Line(x1, y1, x2, y2, thick));
			break;
		case "矩形":
			listShape.add(currentNum, new Rectangle(x1, y1, x2, y2, thick));
			break;
		case "圆":
			listShape.add(currentNum, new Circle(x1, y1, x2, y2, thick));
			break;
		default:
			listShape.add(currentNum, new Word(ToolsPanel.getWord(), x1, y1, x2, y2));
			break;
		}
		repaint();
	}
	
	public void setColor(Color color) {
		if(currentNum < listShape.size()){
			currentShape = listShape.remove(currentNum);
		}
		currentShape.setColor(color);
		listShape.add(currentShape);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {//重写：遍历图像列表画部件
		super.paintComponent(g);
		Graphics2D h = (Graphics2D)g;
		for ( Shape s : listShape )
		{
			s.draw(h);
		}			
	}

}
