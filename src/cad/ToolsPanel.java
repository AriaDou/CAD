package cad;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToolsPanel extends JPanel {//��״ѡ�񹤾���
	/**
	 * 
	 */
	private static final long serialVersionUID = 4245250515525130302L;
	private String currentButton = "ֱ��";
	private String word = "null";
	private String[] arrayButton = {"ֱ��", "����", "Բ", "����"};

	public ToolsPanel(LayoutManager arg0){
		super(arg0);
		for(int i = 0; i < arrayButton.length; i++)
		{
			JButton button = new JButton(arrayButton[i]);
			button.setActionCommand(arrayButton[i]);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					currentButton = e.getActionCommand();
					if(currentButton.equals("����")){
						word = JOptionPane.showInputDialog("Please input a value");
						CAD.setWord();
					}
					CAD.setButton();
				}
			});
			this.add(button);
		}
	}

	public String getCurrentButton() {
		return currentButton;
	}

	public String getWord() {
		return word;
	}
	
	
}
