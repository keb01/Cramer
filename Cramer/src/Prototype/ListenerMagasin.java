package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ListenerMagasin implements MouseListener {

	private Contenant c;
	private ElementDeListe e;
	
	public ListenerMagasin(Contenant c,ElementDeListe e) {
	this.c = c;
	this.e=e;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		c.getContainerArticle().removeAll();
		c.getContainerArticle().revalidate();
		c.getContainerArticle().repaint();
		MagasinDAO DAOp = new MagasinDAO();
		Magasin mag = (Magasin)this.e.getObjet();
		DAOp.getListeProduit(mag);
		c.getP2().clearList();
		for( Produit p : mag.getListeProduits() ){
			ElementDeListe pan = new ElementDeListe(p);
			c.getP2().remplissage(pan);
			pan.addMouseListener(new ListenerProduit(c,pan));
		}
		c.getP2().affichage();
		
		//méthode affichage des produits afficherproduit(mag)
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
