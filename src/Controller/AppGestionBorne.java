package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import DAOClient.ClientBorneDAO;
import DAOClient.ClientZoneDAO;
import DAOClient.Query;
import Model.Borne;
import Model.Zone;
import View.ItemList;
import View.PanelArticle;
import View.PanelDetailBorne;
import View.PanelListe;

public class AppGestionBorne {
	private PanelListe panelZone,panelBorne;
	private PanelDetailBorne panelDetailBorne;
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
		panelDetailBorne = new PanelDetailBorne();
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
		listeBorne = borneDAO.getAllBornes();


		panelDetailBorne.setListenerSuppButton(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteBorne();
			}
		});

		updateListeZone();


		
	}
	
	
	public void updateListeZone(){
		panelZone.removeAll();
		int px = 0;
		for(Zone m : listeZone){
			ItemList label = new ItemList(m.getNom()+" "+m.getDescription());
			label.addMouseListener(new ListenerZone(this,m));
			label.setMaximumSize(new Dimension(300, 37));
			panelZone.add(label);
			px++;
		}
		panelZone.setPreferredSize(new Dimension(300, px*37));
		panelZone.revalidate();
		panelZone.repaint();
	}
	
	public void updateListeBorne(){
		panelBorne.removeAll();
		int px = 0;
		for(Borne p : listeBorne){
			//System.out.println("Borne "+p.getId()+" "+p.getZone().getDescription());
			if(p.getZone().getId() == selectZone.getId()){
				ItemList label = new ItemList("Borne "+p.getId());
				label.setMaximumSize(new Dimension(2000, 37));
				label.addMouseListener(new ListenerBorne(this,p));
				panelBorne.add(label);
				px++;
			}
		
		}
		panelBorne.setPreferredSize(new Dimension(300, px*37));
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
		ArrayList<String> array = new ArrayList<>();
		for(Zone z : listeZone){
			array.add(z.getNom()+" "+z.getDescription());
		}
			
		panelDetailBorne.update("Borne "+p.getId(),p.getZone().getNom()+" "+p.getZone().getDescription(), array.toArray(new String[array.size()]));
		//panelDetailBorne.setListenerModifButton(new ListenerModifArticle(this));
		//panelDetailBorne.setListenerSuppButton(new ListenerDelArticle(this));
		panelDetailBorne.setVisible(true);
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

	public void deleteBorne(){
		borneDAO.delete(selectBorne);
		selectBorne = null;
		panelDetailBorne.setVisible(false);
		listeBorne = borneDAO.getAllBornes();
		updateListeBorne();
	}
}
