package cad;

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
				menu.add(menuItem);
			}
		}
	}

}
