package View;


import javax.swing.JFrame;

public class Fenetre extends JFrame {

	public Fenetre() {
		/*this.pack();
		setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(MAXIMIZED_BOTH);*/
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Application");
		this.setVisible(true);
	}

}
