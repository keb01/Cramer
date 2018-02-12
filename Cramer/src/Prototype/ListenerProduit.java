package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ListenerProduit implements MouseListener{

	private Contenant c;
	private ElementDeListe e;
	
	public ListenerProduit(Contenant c,ElementDeListe e) {
		this.c = c;
		this.e=e;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		c.getContainerArticle().removeAll();
		c.getContainerArticle().revalidate();
		c.getContainerArticle().repaint();
		PanelArticle pa = new PanelArticle((Produit) e.getObjet(),c);
		c.getContainerArticle().add(pa);
		c.revalidate();
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
