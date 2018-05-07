package client.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import client.dtoClient.ClientDAO;
import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.ClientPersonneDAO;
import client.dtoClient.ClientProfilDAO;
import client.dtoClient.Query;
import client.view.AddBorneWindow;
import client.view.ItemList;
import client.view.PanelDetailProfil;
import client.view.PanelListe;
import common.Borne;
import common.Client;
import common.Magasin;
import common.Personne;
import common.Profil;
import common.Zone;

public class AppGestionProfil {
	private PanelListe panelClient,panelProfil;
	private PanelListe panelDetailProfil;
	private JPanel tabPanel;
	private ArrayList<Personne> listeClient;
	private ArrayList<Profil> listeProfil;
	private ArrayList<Magasin> tousMagasins;
	private ClientProfilDAO profilDAO;
	private ClientPersonneDAO clientPersonneDAO;
	private ClientMagasinDAO clientMagasinDAO;
	private Profil selectProfil;
	private Personne selectClient;
	private Query qManager;
	private AddBorneWindow addWindow;
	private JLabel profilCounter;
	
	
	public AppGestionProfil(JPanel tabPanel,Query q){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelClient = new PanelListe();
		panelProfil = new PanelListe();
		panelDetailProfil = new PanelListe();
		tabPanel.add(panelClient,BorderLayout.WEST);
		JScrollPane scroll = new JScrollPane(panelClient);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelClient.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		tabPanel.add(scroll,BorderLayout.WEST);
		tabPanel.add(panelProfil,BorderLayout.CENTER);
		tabPanel.add(panelDetailProfil,BorderLayout.EAST);			
		
		// DAOs initialization
		this.qManager = q;
		
		this.listeClient = new ArrayList<Personne>();
		this.listeProfil = new ArrayList<Profil>();
		this.profilDAO = new ClientProfilDAO(qManager);
		this.clientMagasinDAO =new ClientMagasinDAO(qManager);
		this.clientPersonneDAO = new ClientPersonneDAO(qManager);
			
		//Areas list initialization
		listeClient = clientPersonneDAO.getAllClients(); 
		listeProfil = profilDAO.getAllProfils();

		tousMagasins = clientMagasinDAO.getAllMagasins();
		System.out.println(listeClient.get(0).getIdProfil());

		//*****************Search bar and options*****************
    		// Bar panel settings
    		JPanel searchBar = new JPanel();
    		searchBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    		searchBar.setPreferredSize(new Dimension(600, 40));
    		Border border = searchBar.getBorder();
    		Border margin = new EmptyBorder(0,0,10,0);
    		searchBar.setBorder(new CompoundBorder(border, margin));
    		
    		
    		// Display nb clients
    		//clientCounter = new JLabel(listeClient.size()+" clients");
    		//searchBar.add(clientCounter);    		

    		
    		// display Bar panel
    		tabPanel.add(searchBar,BorderLayout.NORTH);
    		
    	//*******************************************************	

		updateListeClient();


		
	}
	
	
	public void updateListeClient(){
		panelClient.removeAll();
		int px = 1;
		
		for(Personne m : listeClient){
			ItemList label = new ItemList(m.getId() +":"+m.getNom()+" "+m.getPrenom());
			label.addMouseListener(new ListenerClient(this,m));
			label.setMaximumSize(new Dimension(300, 37));
			panelClient.add(label);
			px++;
		}
		panelClient.setPreferredSize(new Dimension(300, px*37));
		panelClient.revalidate();
		panelClient.repaint();
	}
	
	
	
	public void updateListeProfil(){
		panelProfil.removeAll();
		int px = 0;
		if(selectClient.getId()!=0) {
			for(Profil p : listeProfil){
				if(selectClient.getIdProfil() == p.getId()){
					ItemList label = new ItemList(p.getNomProfil() +"parcours");
					label.setMaximumSize(new Dimension(2000, 37));
					label.addMouseListener(new ListenerProfil(this,p));
					panelProfil.add(label);
					px++;
				}
			}	
		}
		panelProfil.setPreferredSize(new Dimension(300, px*37));
		panelProfil.revalidate();
		panelProfil.repaint();
	}
	
	
	public void selectedClient(Personne m) {
		panelDetailProfil.setVisible(true);
		selectClient = m;
		updateListeProfil();
		
	}

	public void selectedProfil(Profil profil) {
		selectProfil=profil;
		ArrayList<Magasin> magasinProfil = new ArrayList<Magasin>();
		int [] tab= new int[10];
		if(profil.getId()!=1 && profil.getId() != 5){
			magasinProfil = profilDAO.getMagasins(profil);
		}else {
			for (int i=0; i<tab.length;i++) {
				Random rand = new Random();
				int randomNum = rand.nextInt(tousMagasins.size());
				tab[i] = randomNum;
				System.out.println(tab[i]);
			}
			
			triBulleCroissant(tab);

			for (int i=0; i<tab.length;i++) {
				Magasin mag = clientMagasinDAO.find(tab[i]);
				magasinProfil.add(mag);
			}
		}
		
	/*	for (int i =0 ; i< listeClient.size()-1; i++) {
			
			Random rand = new Random();
			int randomNum = rand.nextInt(listeProfil.size());
			
			listeClient.get(i).setIdProfil(randomNum);
			
			clientPersonneDAO.updateProfil(listeClient.get(i));
			
			
		}*/
		panelDetailProfil.setVisible(true);
	}
	
	public void updateParcours(ArrayList<Magasin> magasins) {
		panelDetailProfil.removeAll();
		int px = 0;
			for(Magasin m : magasins){
					ItemList label = new ItemList(m.getNom()+" emplacement : "+ m.getIdEmplacement());
					label.setMaximumSize(new Dimension(2000, 37));
					panelDetailProfil.add(label);
					px++;
			}	
		
		panelDetailProfil.setPreferredSize(new Dimension(400, px*37));
		panelDetailProfil.revalidate();
		panelDetailProfil.repaint();
	}
	
	public static void triBulleCroissant(int tableau[]) {
		int longueur = tableau.length;
		int tampon = 0;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				if (tableau[i] > tableau[i + 1]) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
	
	public void afficherFenetreModif(){
		//fenetreModif.update(selectProduit.getNom());
		//fenetreModif.setListenerRecButton(new ListenerRecArticle(this));
		//fenetreModif.setVisible(true);
	}


	
}

