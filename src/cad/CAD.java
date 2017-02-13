package cad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class CAD {
	private JFrame frame;
	private MenuBar menuBar;
	private ToolsPanel toolPanel;
	private ColorPanel colorPanel;
	private static DrawPanel drawPanel;
	
	public CAD(){
		frame = new JFrame("miniCAD");
		
		menuBar = new MenuBar();
		toolPanel = new ToolsPanel(new GridLayout(5,1));
		colorPanel = new ColorPanel(new GridLayout(3,4));
		drawPanel = new DrawPanel();
		
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
	
	public static void setColor(Color color){
		drawPanel.setColor(color);
	}

	public static void main(String[] args) {
		
		CAD cad = new CAD();
		cad.draw(800,700);
	}

}
