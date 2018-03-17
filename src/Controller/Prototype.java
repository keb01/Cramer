package Controller;


import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import View.Fenetre;
import View.PanelArticle;
import View.PanelListe;

public class Prototype {
	public static void main(String[] args) {
		Fenetre fenetrePrincipale = new Fenetre();
		
//Cr�ation des panneaux d'affichage |Magasins|Produits|D�tail Produit|
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel AppGestionProduitPanel = new JPanel();
		tabbedPane.add("Gestion Produit", AppGestionProduitPanel);
		fenetrePrincipale.add(tabbedPane);
		new AppGestionProduit(AppGestionProduitPanel);
		
		
		fenetrePrincipale.setVisible(true);
		
	}
}
