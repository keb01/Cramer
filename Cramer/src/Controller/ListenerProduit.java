package Controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Produit;


public class ListenerProduit implements MouseListener{

	private CoreProto c;
	private Produit p;
	
	
	public ListenerProduit(CoreProto c,Produit p) {
		this.c = c;
		this.p=p;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	c.selectedProduit(p);
		
		
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
