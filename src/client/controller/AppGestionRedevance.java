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

import client.dtoClient.ClientRedevanceDAO;
import client.dtoClient.ClientDAO;
import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.ClientPersonneDAO;
import client.dtoClient.ClientProfilDAO;
import client.dtoClient.ClientRedevanceDAO;
import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.EmplacementDTO;
import client.dtoClient.Query;
import client.view.AddBorneWindow;
import client.view.ItemList;
import client.view.PanelDetailRedevance;
import client.view.PanelDetailRedevance;
import client.view.PanelListe;
import common.Redevance;
import common.Magasin;
import common.Personne;
import common.Profil;
import common.Zone;
import common.Redevance;
import common.Borne;
import common.Emplacement;


public class AppGestionRedevance {

		private PanelListe panelMagasin,panelRedevance;
		private PanelDetailRedevance panelDetailRedevance;
		private JPanel tabPanel;
		private ArrayList<Magasin> listeMagasin;
		private ArrayList<Redevance> listeRedevance;
		private ClientRedevanceDAO RedevanceDAO;
		private ClientMagasinDAO MagasinDAO;
		private Redevance selectRedevance;
		private Magasin selectMagasin;
		private Query qManager;
		private AddBorneWindow addWindow;
		private JLabel RedevanceCounter;
		
		public AppGestionRedevance(JPanel tabPanel,Query q){
			
			// Tab panel initialization 
			this.tabPanel = tabPanel;
			this.tabPanel.setLayout(new BorderLayout());
			panelMagasin = new PanelListe();
			panelRedevance = new PanelListe();
			panelDetailRedevance = new PanelDetailRedevance();
			tabPanel.add(panelMagasin,BorderLayout.WEST);
			JScrollPane scroll = new JScrollPane(panelMagasin);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			
			panelMagasin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			
			tabPanel.add(scroll,BorderLayout.WEST);
			tabPanel.add(panelRedevance,BorderLayout.CENTER);
			tabPanel.add(panelDetailRedevance,BorderLayout.EAST);
			
					
			
			// DAOs initialization
			this.qManager = q;
			
			this.listeMagasin = new ArrayList<Magasin>();
			this.listeRedevance = new ArrayList<Redevance>();
			this.RedevanceDAO = new ClientRedevanceDAO(qManager);
			this.MagasinDAO = new ClientMagasinDAO(qManager);
			
			
			//Areas list initialization
			listeMagasin = MagasinDAO.getAllMagasins(); 
			listeRedevance = RedevanceDAO.getAllRedevances();



	      //*****************Search bar and options*****************
	    		// Bar panel settings
	    		JPanel searchBar = new JPanel();
	    		searchBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    		searchBar.setPreferredSize(new Dimension(600, 40));
	    		Border border = searchBar.getBorder();
	    		Border margin = new EmptyBorder(0,0,10,0);
	    		searchBar.setBorder(new CompoundBorder(border, margin));
	    		
	    		
	    		// display Bar panel
	    		tabPanel.add(searchBar,BorderLayout.NORTH);
	    		
	    	//*******************************************************	

			updatelisteMagasin();


			
		}
		
	
		
		public void updatelisteMagasin(){
			panelMagasin.removeAll();
			panelDetailRedevance.removeAll();
			panelDetailRedevance.revalidate();
			panelDetailRedevance.repaint();
			int px = 1;
			
			for(Magasin m : listeMagasin){
				ItemList label = new ItemList(m.getId() +":"+m.getNom()+" ");
				label.addMouseListener(new ListenerMagasinBis(this,m));
				label.setMaximumSize(new Dimension(300, 37));
				panelMagasin.add(label);
				px++;
			}
			panelMagasin.setPreferredSize(new Dimension(300, px*37));
			panelMagasin.revalidate();
			panelMagasin.repaint();
			
			
			
			
		}
		

		
		
		
		public void updateListeRedevance(){
			panelRedevance.removeAll();
			panelDetailRedevance.removeAll();
			panelDetailRedevance.revalidate();
			panelDetailRedevance.repaint();
			int px = 0;
			if(selectMagasin.getId()!=0) {
				for(Redevance p : listeRedevance){
					if(selectMagasin.getId() == p.getId_magasin().getId()){
						ItemList label = new ItemList("Voir la redevance");
						label.setMaximumSize(new Dimension(2000, 37));
						label.addMouseListener(new ListenerRedevance(this,p));
						panelRedevance.add(label);
						px++;
					}
				}	
			}
			panelRedevance.setPreferredSize(new Dimension(300, px*37));
			panelRedevance.revalidate();
			panelRedevance.repaint();
		}
		

		public void selectedMagasin(Magasin m) {
			panelDetailRedevance.setVisible(true);
			selectMagasin = m;
			updateListeRedevance();
			
		}

		public void selectedRedevance(Redevance p) {
			selectRedevance = p;
			ArrayList<String> array = new ArrayList<>();
			for(Magasin z : listeMagasin){
				array.add(z.getId()+": "+z.getNom()+" "+z.getDescription());
			}
				
			//panelDetailRedevance.update(p.getid_Redevance(),p.getId_magasin().getId(),p.getNom_magasin(),p.getMontant_redevance(),p.getDate_redevance());
			panelDetailRedevance.update(p.getid_Redevance());

			panelDetailRedevance.setVisible(true);
		}

	
		

		public void updateRedevance() {
	        String selectedMagasin = panelDetailRedevance.getSelectedMagasin();
	        String[] parts = selectedMagasin.split(":");
	        for(Magasin z : listeMagasin){
	            if(z.getId() == Integer.parseInt(parts[0])){
	                selectRedevance.setId_magasin(z);
	            }
	        }
	        RedevanceDAO.update(selectRedevance);
	        updateListeRedevance();
			
		}
		
		
		
	}
