package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import DAOClient.ClientProfilDAO;
import DAOClient.ClientPersonneDAO;
import DAOClient.ClientDAO;
import DAOClient.Query;
import Model.Profil;
import Model.Personne;
import Model.Client;
import View.AddBorneWindow;
import View.ItemList;
//import View.PanelArticle;
import View.PanelDetailProfil;
import View.PanelListe;

public class AppGestionProfil {
	private PanelListe panelClient,panelProfil;
	private PanelDetailProfil panelDetailProfil;
	private JPanel tabPanel;
	private ArrayList<Personne> listeClient;
	private ArrayList<Profil> listeProfil;
	private ClientProfilDAO profilDAO;
	private ClientPersonneDAO clientPersonneDAO;
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
		panelDetailProfil = new PanelDetailProfil();
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
		this.clientPersonneDAO = new ClientPersonneDAO(qManager);
			
		//Areas list initialization
		listeClient = clientPersonneDAO.getAllClients(); 
		listeProfil = profilDAO.getAllProfils();
 

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
			System.out.println(m);
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
		profilCounter.setText(listeProfil.size()+" profil");
		if(selectClient.getId() != 0){
			for(Profil p : listeProfil){
					ItemList label = new ItemList("Profil "+p.getId());
					label.setMaximumSize(new Dimension(2000, 37));
					label.addMouseListener(new ListenerProfil(this,p));
					panelProfil.add(label);
					px++;
			}
		}
		panelProfil.setPreferredSize(new Dimension(300, px*37));
		panelProfil.revalidate();
		panelProfil.repaint();
	}
	

	public void selectedClient(Personne m) {
		panelDetailProfil.setVisible(false);
		selectClient = m;
		updateListeProfil();
		
	}

	public void afficherFenetreModif(){
		//fenetreModif.update(selectProduit.getNom());
		//fenetreModif.setListenerRecButton(new ListenerRecArticle(this));
		//fenetreModif.setVisible(true);
	}


	
}

