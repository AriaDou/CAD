package cad;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CAD {

	public static void main(String[] args) {
		JFrame frame = new JFrame("CAD��ͼ");
		Picture picture = new Picture(420, 300);
		JButton LineButton = new JButton("ֱ��");
		JButton RectButton = new JButton("����");
		JButton CircButton = new JButton("Բ");
		JButton WordButton = new JButton("����");
		frame.add(picture);
		picture.draw();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
