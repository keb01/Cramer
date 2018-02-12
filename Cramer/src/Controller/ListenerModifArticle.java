package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerModifArticle implements ActionListener{
	private CoreProto c;
	
	public ListenerModifArticle(CoreProto c) {
		this.c = c;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		c.afficherFenetreModif();
		
	}

}
