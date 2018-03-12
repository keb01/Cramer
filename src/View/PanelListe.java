package View;


import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class PanelListe extends JPanel{
	

	public PanelListe(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(300,600));
		this.setVisible(true);
	}

	
}
