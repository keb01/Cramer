package client.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import client.dtoClient.ClientAchatDTO;
import client.dtoClient.ClientFournisseurDTO;
import client.dtoClient.Query;
import client.view.FenetreModificationArticle;
import client.view.PanelArticle;
import client.view.PanelListe;
import common.Achat;
import common.Fournisseur;
import common.Magasin;

public class AppGestionStock {
	private JPanel tabPanel;
	private JPanel panelCreerAchat;
	private JPanel panelListeAchat;
	private JPanel panelDetailAchat;
	private ClientFournisseurDTO fournisseurDTO; 
	private ClientAchatDTO achatDTO;
	private ArrayList<Achat> listeAchats;
	private ArrayList<Fournisseur> listeFournisseurs;
	private JComboBox<String> selectFournisseur;
	
	public AppGestionStock(JPanel tabPanel, Query q){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelListeAchat = new PanelListe();
		panelCreerAchat = new JPanel();
		panelDetailAchat = new JPanel();
		tabPanel.add(panelCreerAchat,BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane(panelListeAchat);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabPanel.add(scroll,BorderLayout.WEST);
		tabPanel.add(panelDetailAchat,BorderLayout.CENTER);
		
		// DAOs initialization
		this.listeAchats = new ArrayList<>();
		
		this.fournisseurDTO = new ClientFournisseurDTO(q);
		this.achatDTO = new ClientAchatDTO(q);
		
		//Stores list initialization
		listeFournisseurs = fournisseurDTO .getAllFournisseurs();
		
		
		String[] fournisseursSiret = new String[listeFournisseurs.size()];
		for ( int i = 0; i < fournisseursSiret.length; i++ )
			fournisseursSiret[i] = listeFournisseurs.get(i).siret;
		
		selectFournisseur = new JComboBox<>(fournisseursSiret);
		panelCreerAchat.add(selectFournisseur);
		
		JTextField total = new JTextField();
        panelCreerAchat.add(total);
        
        JButton creer = new JButton("Créer");
        panelCreerAchat.add(creer);
        
        //creer.addActionListener(new );
		
	}
	
	public void updateListeFournisseurs()
	{
		listeFournisseurs = fournisseurDTO .getAllFournisseurs();
		selectFournisseur.removeAllItems();
		for ( Fournisseur f : listeFournisseurs )
			selectFournisseur.addItem(f.siret);
		
		/*String[] fournisseursSiret = new String[listeFournisseurs.size()];
		for ( int i = 0; i < fournisseursSiret.length; i++ )
			fournisseursSiret[i] = listeFournisseurs.get(i).siret;
		*/
	}
	
	public void updateListeAchats()
	{
		listeAchats = achatDTO.getAllAchats();
		panelListeAchat.removeAll();
		for ( Achat a : listeAchats )
		{
			String aLabelText = a.dateAchat;
			JLabel aPanel = new JLabel(aLabelText);
			//aPanel.addMouseListener();
			
		}
	}
	

	public void creerAchat(Achat a)
	{
		achatDTO.create(a);
		
	}
}
