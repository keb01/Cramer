package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ListenerProduit implements MouseListener{

	private Produit prod;
	private JPanel c;
	
	public ListenerProduit(Produit prod, JPanel c) {
	this.prod=prod;	
	this.c = c;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		c.removeAll();
		PanelArticle pa = new PanelArticle(prod);
		c.add(pa);
		pa.setVisible(true);
		c.revalidate();
		c.repaint();
		
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
