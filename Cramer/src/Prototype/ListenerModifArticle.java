package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerModifArticle implements ActionListener{
	private PanelArticle panel;
	
	public ListenerModifArticle(PanelArticle p) {
		this.panel = p;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new FenetreModificationArticle(panel);
		
	}

}
