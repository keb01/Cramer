package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDelArticle implements ActionListener{
	private PanelArticle panel;
	
	public ListenerDelArticle(PanelArticle p) {
		this.panel = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.supprimerArticle();
		
	}

	
	
	
}
