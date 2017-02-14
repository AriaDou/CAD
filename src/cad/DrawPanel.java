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
	private Shape currentShape = null;
	private String word = "null";
	private String button = "直线";
	private boolean isAdd = true;
	private int index = 0;
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
						index = listShape.indexOf(s);
						isAdd = false;
						break;
					}
					index = listShape.size();
					isAdd = true;
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				if(index < listShape.size() && isAdd == false){
					currentShape = listShape.remove(index);
					currentShape.relocate(x2-x1, y2-y1);
					x1 = x2;
					y1 = y2;
					listShape.add(currentShape);
					index = listShape.size()-1;
					repaint();
				}
				else addShapes();
			}
		});
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(index < listShape.size()){
					currentShape = listShape.remove(index);
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
						index = 0;
					else
						index = listShape.size() - 1;
				}
			}
		});
	}
	
	public void addShapes() {
		if(index < listShape.size())
			listShape.remove(index);
		switch (button) {
		case "直线":
			listShape.add(index, new Line(x1, y1, x2, y2, thick));
			break;
		case "矩形":
			listShape.add(index, new Rectangle(x1, y1, x2, y2, thick));
			break;
		case "圆":
			listShape.add(index, new Circle(x1, y1, x2, y2, thick));
			break;
		default:
			listShape.add(index, new Word(word, x1, y1, x2, y2));
			break;
		}
		repaint();
	}
	
	public void setColor(Color color) {
		if(listShape.isEmpty())
				return;
		if(index < listShape.size()){
			currentShape = listShape.remove(index);
		}
		currentShape.setColor(color);
		listShape.add(currentShape);
		repaint();
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public void setButton(String button) {
		this.button = button;
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

	public ArrayList<Shape> save() {
		return listShape;
	}

	public void recover(ArrayList<Shape> listShape) {
		this.listShape = listShape;
		currentShape = null;
		word = "null";
		button = "直线";
		isAdd = true;
		if(listShape.isEmpty())
			index = 0;
		else
			index = listShape.size() - 1;
		thick = 3.0f;
		repaint();
	}
}
