package cad;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import shapes.Shape;

public class CAD {
	private JFrame frame;
	private MenuBar menuBar;
	private ToolsPanel toolPanel;
	private ColorPanel colorPanel;
	private DrawPanel drawPanel;
	
	public CAD(){
		frame = new JFrame("miniCAD");
		
		menuBar = new MenuBar(this);
		toolPanel = new ToolsPanel(this, new GridLayout(5,1));
		colorPanel = new ColorPanel(this, new GridLayout(3,4));
		drawPanel = new DrawPanel(this);
		
		toolPanel.add(colorPanel);
		
		frame.add(drawPanel);
		frame.add(toolPanel, BorderLayout.EAST);
		frame.setJMenuBar(menuBar);
	}
	
	public void draw(int width, int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	public void setColor() {//更新颜色
		drawPanel.setColor(colorPanel.getChangeColor());
	}
	
	public void setButton() {//更新按钮
		drawPanel.setButton(toolPanel.getCurrentButton());
	}
	
	public void setWord(){//更新单词
		drawPanel.setWord(toolPanel.getWord());
	}
	
	public void saveFile() {//保存文件
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.cad)", "cad");
		chooser.setFileFilter(filter);
		int res = chooser.showSaveDialog(null);
		if(res == JFileChooser.APPROVE_OPTION){
			String path = chooser.getSelectedFile().getAbsolutePath() + ".cad";
			try {
				ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(path));
				objOut.writeObject(drawPanel.save());
				objOut.flush();
				objOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void openFile() {//打开文件
		JFileChooser chooser = new JFileChooser("请选择文件");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.cad)", "cad");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if(res == JFileChooser.APPROVE_OPTION){
			String path = chooser.getSelectedFile().getAbsolutePath();
			try {
				ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(path));
				@SuppressWarnings("unchecked")
				ArrayList<Shape> listShape = (ArrayList<Shape>)objIn.readObject();
				drawPanel.recover(listShape);
				objIn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		CAD cad = new CAD();
		cad.draw(800,700);
	}

}
