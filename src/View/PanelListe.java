package View;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class PanelListe extends JPanel{
	

	public PanelListe(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(300,600));
		this.setBorder(new LineBorder(Color.GRAY));
		this.setVisible(true);
	}

	
}
