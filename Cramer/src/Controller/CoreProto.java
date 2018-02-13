package Controller;


import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;

import Model.Magasin;
import Model.MagasinDAO;
import Model.Produit;
import Model.ProduitDAO;
import View.FenetreModificationArticle;
import View.PanelArticle;
import View.PanelListe;



public class CoreProto {
	private PanelListe panelMag,panelArt;
	private PanelArticle panelDetailArt;
	private FenetreModificationArticle fenetreModif;
	private ArrayList<Magasin> listeMag;
	private MagasinDAO magasinDAO;
	private ProduitDAO produitDAO;
	private Magasin selectMag;
	private Produit selectProduit;
	
	public CoreProto(PanelListe pMag,PanelListe pArt, PanelArticle pDet){
		
		fenetreModif = new FenetreModificationArticle();
		this.panelMag = pMag;
		this.panelArt = pArt;
		this.panelDetailArt =pDet;
		this.listeMag = new ArrayList<Magasin>();
		this.magasinDAO = new MagasinDAO();
		this.produitDAO = new ProduitDAO();
		
		
		//Initialisation de la liste des magasins
		listeMag = magasinDAO.getAllMagasins();
		updateListeMagasin();
		
	}
	
	
	public void updateListeMagasin(){
		panelMag.removeAll();
		int px = 0;
		for(Magasin m : listeMag){
			JLabel label = new JLabel(m.getNom());
			label.addMouseListener(new ListenerMagasin(this,m));
			panelMag.add(label);
			px++;
		}
		panelMag.setPreferredSize(new Dimension(300, px*16));
		panelMag.revalidate();
		panelMag.repaint();
	}
	
	public void updateListeProduit(){
		panelArt.removeAll();
		int px = 0;
		for(Produit p : selectMag.getListeProduits()){
			JLabel label = new JLabel(p.getNom());
			label.addMouseListener(new ListenerProduit(this,p));
			panelArt.add(label);
			px++;
		}
		panelArt.setPreferredSize(new Dimension(300, px*16));
		panelArt.revalidate();
		panelArt.repaint();
	}
	

	public void selectedMagasin(Magasin m) {
		panelDetailArt.setVisible(false);
		selectMag = m;
		magasinDAO.chargerListeProduit(selectMag);
		updateListeProduit();
		
	}

	public void selectedProduit(Produit p) {
		selectProduit = p;
		panelDetailArt.update(p.getNom(),p.getDescription(),p.getUrlImage(),p.getProvenance(),p.getPoids(),p.getPrix());
		panelDetailArt.setListenerModifButton(new ListenerModifArticle(this));
		panelDetailArt.setListenerSuppButton(new ListenerDelArticle(this));
		panelDetailArt.setVisible(true);
	}

	public void afficherFenetreModif(){
		fenetreModif.update(selectProduit.getNom());
		fenetreModif.setListenerRecButton(new ListenerRecArticle(this));
		fenetreModif.setVisible(true);
	}


	public void updateArticle() {
		selectProduit.setNom(fenetreModif.getJtf1().getText());
		panelDetailArt.update(selectProduit.getNom(),selectProduit.getDescription(),selectProduit.getUrlImage(),selectProduit.getProvenance(),selectProduit.getPoids(),selectProduit.getPrix());
		produitDAO.update(selectProduit);
		magasinDAO.chargerListeProduit(selectMag);
		updateListeProduit();
		fenetreModif.dispose();
		
	}

	public void supprimerArticle(){
		produitDAO.deleteInMagasin(selectProduit, selectMag.getId());
		selectProduit = null;
		panelDetailArt.setVisible(false);
		magasinDAO.chargerListeProduit(selectMag);
		updateListeProduit();
	}
	
}
