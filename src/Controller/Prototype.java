package Controller;


import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import View.Fenetre;
import View.PanelArticle;
import View.PanelListe;

public class Prototype {
	public static void main(String[] args) {
		Fenetre fenetrePrincipale = new Fenetre();
		
//Cr�ation des panneaux d'affichage |Magasins|Produits|D�tail Produit|
		PanelListe panelMag = new PanelListe();
		PanelListe panelArt = new PanelListe();
		PanelArticle panelDetailArt = new PanelArticle();
		
		fenetrePrincipale.add(panelMag,BorderLayout.WEST);
		JScrollPane scroll = new JScrollPane(panelMag);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		fenetrePrincipale.add(scroll,BorderLayout.WEST);
		
		fenetrePrincipale.add(panelArt,BorderLayout.CENTER);
		fenetrePrincipale.add(panelDetailArt,BorderLayout.EAST);
		new AppGestionProduit(panelMag,panelArt,panelDetailArt);
		
		
		fenetrePrincipale.setVisible(true);
		
	}
}
