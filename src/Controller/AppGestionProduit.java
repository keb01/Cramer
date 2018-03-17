package Controller;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Magasin;
import Model.MagasinDAO;
import Model.Article;
import Model.ArticleDAO;
import View.FenetreModificationArticle;
import View.PanelArticle;
import View.PanelListe;



public class AppGestionProduit {
	private PanelListe panelMag,panelArt;
	private PanelArticle panelDetailArt;
	private JPanel tabPanel;
	private FenetreModificationArticle fenetreModif;
	private ArrayList<Magasin> listeMag;
	private MagasinDAO magasinDAO;
	private ArticleDAO produitDAO;
	private Magasin selectMag;
	private Article selectProduit;
	
	public AppGestionProduit(JPanel tabPanel){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelMag = new PanelListe();
		panelArt = new PanelListe();
		panelDetailArt = new PanelArticle();
		tabPanel.add(panelMag,BorderLayout.WEST);
		JScrollPane scroll = new JScrollPane(panelMag);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabPanel.add(scroll,BorderLayout.WEST);
		tabPanel.add(panelArt,BorderLayout.CENTER);
		tabPanel.add(panelDetailArt,BorderLayout.EAST);
		
		fenetreModif = new FenetreModificationArticle();
		// DAOs initialization
		this.listeMag = new ArrayList<Magasin>();
		this.magasinDAO = new MagasinDAO();
		this.produitDAO = new ArticleDAO();
		
		
		//Stores list initialization
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
		for(Article p : selectMag.getListeProduits()){
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

	public void selectedProduit(Article p) {
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
