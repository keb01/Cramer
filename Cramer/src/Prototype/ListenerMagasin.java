package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ListenerMagasin implements MouseListener {

	private PanelListeObjet panel;
	private PanelListe p2;
	private Fenetre f;
	private Contenant p;
	
	public ListenerMagasin(PanelListeObjet panel,PanelListe p2,Contenant p,Fenetre f) {
	this.panel=panel;
	this.p2 = p2;
	this.f=f;
	this.p = p;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		p2.removeAll();
		// TODO Auto-generated method stub
		MagasinDAO DAOp = new MagasinDAO();
		Magasin mag = (Magasin)this.panel.getObjet();
		DAOp.getListeProduit(mag);
		
		for( Produit p : mag.getListeProduits() ){
			PanelListeObjet pan = new PanelListeObjet(p);
			
			p2.add(pan);
		}
		p.add(p2);
		f.repaint();
		f.setVisible(true);
		
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
