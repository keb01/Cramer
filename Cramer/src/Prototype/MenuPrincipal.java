package Prototype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

	private JButton j = new JButton("ok");
	public MenuPrincipal() {
	
		this.pack();
		setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		MenuPrincipal app = new MenuPrincipal();
	}
}
