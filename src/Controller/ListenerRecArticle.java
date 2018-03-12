package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRecArticle implements ActionListener{
	private CoreProto c;
	
	public ListenerRecArticle(CoreProto c) {
		this.c = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		c.updateArticle();
		
	}

}
