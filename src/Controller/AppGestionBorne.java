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

import DAOClient.ClientBorneDAO;
import DAOClient.ClientZoneDAO;
import DAOClient.Query;
import Model.Borne;
import Model.Zone;
import View.AddBorneWindow;
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
	private AddBorneWindow addWindow;
	private JLabel borneCounter;
	
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
		
		
		panelZone.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
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

        panelDetailBorne.setListenerModifButton(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateBorne();
            }
        });


      //*****************Search bar and options*****************
    		// Bar panel settings
    		JPanel searchBar = new JPanel();
    		searchBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    		searchBar.setPreferredSize(new Dimension(600, 40));
    		Border border = searchBar.getBorder();
    		Border margin = new EmptyBorder(0,0,10,0);
    		searchBar.setBorder(new CompoundBorder(border, margin));
    		
    		
    		// Display nb bornes available
    		borneCounter = new JLabel(listeBorne.size()+" bornes");
    		searchBar.add(borneCounter);
    		JButton addButton = new JButton("Ajouter");
    		searchBar.add(addButton);
    		
    		
    		
    		//init add Borne window with listZone parameter
    		ArrayList<String> array = new ArrayList<>();
    		for(Zone z : listeZone){
    			array.add(z.getId()+": "+z.getNom()+" "+z.getDescription());
    		}
    		addWindow = new AddBorneWindow(this, array.toArray(new String[array.size()]));
    		addButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addWindow.setVisible(true);
				}
			});
    		
    		// display Bar panel
    		tabPanel.add(searchBar,BorderLayout.NORTH);
    		
    	//*******************************************************	

		updateListeZone();


		
	}
	
	
	public void updateListeZone(){
		panelZone.removeAll();
		int px = 1;
		Zone touteZone = new Zone(0, "Toutes", "les Zones", 1);
		selectZone = touteZone;
		ItemList lbl = new ItemList(touteZone.getNom()+" "+touteZone.getDescription());
		lbl.addMouseListener(new ListenerZone(this,touteZone));
		lbl.setMaximumSize(new Dimension(300, 37));
		panelZone.add(lbl);
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
		borneCounter.setText(listeBorne.size()+" bornes");
		if(selectZone.getId() == 0){
			for(Borne p : listeBorne){
					ItemList label = new ItemList("Borne "+p.getId());
					label.setMaximumSize(new Dimension(2000, 37));
					label.addMouseListener(new ListenerBorne(this,p));
					panelBorne.add(label);
					px++;
			}
		}else{
			for(Borne p : listeBorne){
				if(p.getZone().getId() == selectZone.getId()){
					ItemList label = new ItemList("Borne "+p.getId());
					label.setMaximumSize(new Dimension(2000, 37));
					label.addMouseListener(new ListenerBorne(this,p));
					panelBorne.add(label);
					px++;
				}
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
			array.add(z.getId()+": "+z.getNom()+" "+z.getDescription());
		}
			
		panelDetailBorne.update("Borne "+p.getId(),p.getZone().getId()+": "+p.getZone().getNom()+" "+p.getZone().getDescription(), array.toArray(new String[array.size()]));
		//panelDetailBorne.setListenerModifButton(new ListenerModifArticle(this));
		//panelDetailBorne.setListenerSuppButton(new ListenerDelArticle(this));
		panelDetailBorne.setVisible(true);
	}

	public void afficherFenetreModif(){
		//fenetreModif.update(selectProduit.getNom());
		//fenetreModif.setListenerRecButton(new ListenerRecArticle(this));
		//fenetreModif.setVisible(true);
	}


	public void updateBorne() {
        String selectedZone = panelDetailBorne.getSelectedZone();
        String[] parts = selectedZone.split(":");
        for(Zone z : listeZone){
            if(z.getId() == Integer.parseInt(parts[0])){
                selectBorne.setZone(z);
            }
        }
        borneDAO.update(selectBorne);
        updateListeBorne();
		
	}
	
	public void addBorne(String zone){
		String[] parts = zone.split(":");
		borneDAO.create(new Borne(-1, new Zone(Integer.parseInt(parts[0]), "", "",1)));
		listeBorne = borneDAO.getAllBornes();
	    updateListeBorne();
	    addWindow.dispose();
	}

	public void deleteBorne(){
		borneDAO.delete(selectBorne);
		selectBorne = null;
		panelDetailBorne.setVisible(false);
		listeBorne = borneDAO.getAllBornes();
		updateListeBorne();
	}
}
