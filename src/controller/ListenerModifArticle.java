package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerModifArticle implements ActionListener{
	private AppGestionProduit c;
	
	public ListenerModifArticle(AppGestionProduit c) {
		this.c = c;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		c.afficherFenetreModif();
		
	}

}
