package pdstest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IHMApp extends JFrame {

	private JButton j = new JButton("ok");
	public IHMApp() {
	
		this.pack();
		setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		IHMApp app = new IHMApp();
	}
}
