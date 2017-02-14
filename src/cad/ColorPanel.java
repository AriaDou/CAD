package cad;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class ColorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6412809820291040827L;
	private Color[] arrayColor = {
			Color.BLACK, Color.BLUE, Color.CYAN, 
			Color.GRAY, Color.GREEN, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.PINK,
			Color.RED, Color.WHITE, Color.YELLOW};
	private  Color changeColor = Color.BLACK;
	
	public ColorPanel(LayoutManager layout) {
		super(layout);
		for(int i = 0; i<arrayColor.length; i++){
			JPanel colorPanelItem = new JPanel();
			colorPanelItem.setBackground(arrayColor[i]);
			colorPanelItem.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					JPanel colorItem = (JPanel) e.getSource();
					changeColor = colorItem.getBackground();
					CAD.setColor();
				}
				
			});
			add(colorPanelItem);
		}
	}

	public Color getChangeColor() {
		return changeColor;
	}

}
