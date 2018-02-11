package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRecArticle implements ActionListener{
	private FenetreModificationArticle f;
	
	public ListenerRecArticle(FenetreModificationArticle f) {
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		f.modifierArticle();
		
	}

}
