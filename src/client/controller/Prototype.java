package client.controller;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import client.dtoClient.Query;
import client.view.Fenetre;

public class Prototype {
	public static void main(String[] args) {
		Fenetre fenetrePrincipale = new Fenetre();
		
//Init of the cores and panels of each services, (todo : depending on the type of user logged in)
		
		JTabbedPane tabbedPane = new JTabbedPane();
		fenetrePrincipale.add(tabbedPane);
		
			
			//Adding AppGestionProduitPanel to the main Window and starting the core
			//JPanel AppGestionProduitPanel = new JPanel();
			//tabbedPane.add("Gestion Produits", AppGestionProduitPanel);
			//new AppGestionProduit(AppGestionProduitPanel);
			
			//Adding AppGestionBornePanel to the main Window and starting the core
			Query q = new Query();
			JPanel AppGestionBornePanel = new JPanel();
			
			JPanel AppGestionProfilPanel = new JPanel();
			
			tabbedPane.add("Gestion Bornes", AppGestionBornePanel);
			tabbedPane.add("Gestion Profil",AppGestionProfilPanel);
			
			new AppGestionBorne(AppGestionBornePanel,q);
			new AppGestionProfil(AppGestionProfilPanel,q);
		
		
		fenetrePrincipale.setVisible(true);
	}
}