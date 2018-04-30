package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDelArticle implements ActionListener{

	private AppGestionProduit c;
	
	public ListenerDelArticle(AppGestionProduit c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c.supprimerArticle();
		
	}
	
	
}
