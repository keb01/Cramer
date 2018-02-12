package Prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class PanelListe extends JPanel{
	
	ArrayList<ElementDeListe> liste;
	public PanelListe(){
		this.setPreferredSize(new Dimension(300,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(new LineBorder(Color.RED));
		liste = new ArrayList<ElementDeListe>();
		
		
	}

	public void remplissage(ElementDeListe e) {
		liste.add(e);
	}
	
	public void affichage() {
		this.removeAll();
		for (ElementDeListe e : liste) {
			this.add(e);
		}
		revalidate();
		repaint();
	}
	
	public void supprimer(ElementDeListe e ) {
		liste.remove(e);
		this.affichage();
	}
	public void clearList() {
		liste.clear();
	}
	
}
