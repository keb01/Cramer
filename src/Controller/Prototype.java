package Controller;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import View.Fenetre;

public class Prototype {
	public static void main(String[] args) {
		Fenetre fenetrePrincipale = new Fenetre();
		
//Init of the cores and panels of each services, (todo : depending on the type of user logged in)
		
		JTabbedPane tabbedPane = new JTabbedPane();
		fenetrePrincipale.add(tabbedPane);
		
		//Adding AppGestionProduitPanel to the main Window and starting the core
		JPanel AppGestionProduitPanel = new JPanel();
		tabbedPane.add("Gestion Produits", AppGestionProduitPanel);
		new AppGestionProduit(AppGestionProduitPanel);
		
		//Adding AppGestionProduitPanel to the main Window and starting the core
		JPanel AppGestionBornePanel = new JPanel();
		tabbedPane.add("Gestion Bornes", AppGestionBornePanel);
		//new AppGestionProduit(AppGestionProduitPanel);
		
		fenetrePrincipale.setVisible(true);
	}
}
