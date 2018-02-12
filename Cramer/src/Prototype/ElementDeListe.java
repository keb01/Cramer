package Prototype;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ElementDeListe extends JPanel{

	
	private Object objet;
	private JLabel label;
	
	public Object getObjet() {
		return objet;
	}

	public void setObjet(Object objet) {
		this.objet = objet;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ElementDeListe(Magasin m) {
		super();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.objet = m;
		this.label = new JLabel(m.getNom());
		this.add(label);
		this.setVisible(true);
	}
	
	public ElementDeListe(Produit p) {
		super();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.objet = p;
		this.label = new JLabel(p.getNom());
		this.add(label);
		this.setVisible(true);
	}
	
	public void affichage(){
		this.label.setText(((Produit) objet).getNom());
		revalidate();
		repaint();
	}
	
	public void ModifElement(Produit p){
		this.objet = p;
		affichage();

	}

}
