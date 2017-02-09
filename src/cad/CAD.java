package cad;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CAD {

	public static void main(String[] args) {
		JFrame frame = new JFrame("CAD制图");
		Picture picture = new Picture(420, 300);
		JButton LineButton = new JButton("直线");
		JButton RectButton = new JButton("矩形");
		JButton CircButton = new JButton("圆");
		JButton WordButton = new JButton("文字");
		frame.add(picture);
		picture.draw();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
