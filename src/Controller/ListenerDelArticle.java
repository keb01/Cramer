package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDelArticle implements ActionListener{

	private CoreProto c;
	
	public ListenerDelArticle(CoreProto c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c.supprimerArticle();
		
	}
	
	
}
