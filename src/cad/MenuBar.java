package cad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4452187840010122069L;
	private String[] arrayMenu = {"文件", };
	private String[][] arrayMenuItem = {{"保存", "打开", }, };
	
	public MenuBar() {
		
		for(int i = 0; i<arrayMenu.length; i++){
			JMenu menu = new JMenu(arrayMenu[i]);
			add(menu);
			for(int j = 0; j<arrayMenuItem[i].length; j++){
				JMenuItem menuItem = new JMenuItem(arrayMenuItem[i][j]);
				menuItem.setEnabled(true);
				menuItem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JMenuItem menuItem = (JMenuItem)e.getSource();
						String text = menuItem.getText();
						if(text.equals("保存"))
							CAD.saveFile();
						else if (text.equals("打开")) {
							CAD.openFile();
						}
					}
				});
				menu.add(menuItem);
			}
		}
	}

}
