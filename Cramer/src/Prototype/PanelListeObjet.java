package Prototype;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelListeObjet extends JPanel{

	
	private Object objet;
	private JLabel label;
	
	public PanelListeObjet(Magasin m) {
		this.objet = m;
		this.label = new JLabel(m.getNom());
		this.add(label);
	}

}
