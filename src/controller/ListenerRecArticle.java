package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRecArticle implements ActionListener{
	private AppGestionProduit c;
	
	public ListenerRecArticle(AppGestionProduit c) {
		this.c = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		c.updateArticle();
		
	}

}
