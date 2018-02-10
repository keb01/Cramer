package Prototype;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelListeObjet extends JPanel{

	
	private Object objet;
	private JLabel label;
	
	public PanelListeObjet(Magasin m) {
		super();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.objet = m;
		this.label = new JLabel(m.getNom());
		this.add(label);
		this.setVisible(true);
	}

}
