package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import DAOClient.ClientBorneDAO;
import DAOClient.ClientZoneDAO;
import DAOClient.Query;
import Model.Borne;
import Model.Zone;
import View.PanelArticle;
import View.PanelListe;

public class AppGestionBorne {
	private PanelListe panelZone,panelBorne;
	private PanelArticle panelDetailBorne;
	private JPanel tabPanel;
	private ArrayList<Zone> listeZone;
	private ArrayList<Borne> listeBorne;
	private ClientBorneDAO borneDAO;
private ClientZoneDAO zoneDAO;
	private Borne selectBorne;
	private Zone selectZone;
	private Query qManager;
	
	public AppGestionBorne(JPanel tabPanel,Query q){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelZone = new PanelListe();
		panelBorne = new PanelListe();
		panelDetailBorne = new PanelArticle();
		tabPanel.add(panelZone,BorderLayout.WEST);
		JScrollPane scroll = new JScrollPane(panelZone);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabPanel.add(scroll,BorderLayout.WEST);
		tabPanel.add(panelBorne,BorderLayout.CENTER);
		tabPanel.add(panelDetailBorne,BorderLayout.EAST);
		
		// DAOs initialization
		this.qManager = q;
		
		this.listeZone = new ArrayList<Zone>();
		this.listeBorne = new ArrayList<Borne>();
		this.borneDAO = new ClientBorneDAO(qManager);
		this.zoneDAO = new ClientZoneDAO(qManager);
		
		
		//Areas list initialization
		listeZone = zoneDAO.getAllZones(); 
		//listeBorne = borneDAO.getAllBornes(); A FAIRE JM

		updateListeZone();
		
	}
	
	
	public void updateListeZone(){
		panelZone.removeAll();
		int px = 0;
		for(Zone m : listeZone){
			JLabel label = new JLabel(m.getNom());
			label.addMouseListener(new ListenerZone(this,m));
			panelZone.add(label);
			px++;
		}
		panelZone.setPreferredSize(new Dimension(300, px*16));
		panelZone.revalidate();
		panelZone.repaint();
	}
	
	public void updateListeBorne(){
		panelBorne.removeAll();
		int px = 0;
		for(Borne p : listeBorne){
			if(p.getZone().getId() == selectZone.getId()){
				JLabel label = new JLabel("Borne "+p.getId());
				label.addMouseListener(new ListenerBorne(this,p));
				panelBorne.add(label);
				px++;
			}
			
		}
		panelBorne.setPreferredSize(new Dimension(300, px*16));
		panelBorne.revalidate();
		panelBorne.repaint();
	}
	

	public void selectedZone(Zone m) {
		panelDetailBorne.setVisible(false);
		selectZone = m;
		updateListeBorne();
		
	}

	public void selectedBorne(Borne p) {
		selectBorne = p;
		//panelDetailBorne.update(p.getNom(),p.getDescription(),p.getUrlImage(),p.getProvenance(),p.getPoids(),p.getPrix());
		//panelDetailBorne.setListenerModifButton(new ListenerModifArticle(this));
		//panelDetailBorne.setListenerSuppButton(new ListenerDelArticle(this));
		//panelDetailBorne.setVisible(true);
	}

	public void afficherFenetreModif(){
		//fenetreModif.update(selectProduit.getNom());
		//fenetreModif.setListenerRecButton(new ListenerRecArticle(this));
		//fenetreModif.setVisible(true);
	}


	public void updateArticle() {
		//selectProduit.setNom(fenetreModif.getJtf1().getText());
		//panelDetailArt.update(selectProduit.getNom(),selectProduit.getDescription(),selectProduit.getUrlImage(),selectProduit.getProvenance(),selectProduit.getPoids(),selectProduit.getPrix());
		//produitDAO.update(selectProduit);
		//magasinDAO.chargerListeProduit(selectMag);
		//updateListeProduit();
		//fenetreModif.dispose();
		
	}

	public void supprimerArticle(){
		//produitDAO.deleteInMagasin(selectProduit, selectMag.getId());
		//selectProduit = null;
		//panelDetailArt.setVisible(false);
		//magasinDAO.chargerListeProduit(selectMag);
		//updateListeProduit();
	}
}
