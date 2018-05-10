package client.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.EmplacementDTO;
import client.dtoClient.Query;
import client.model.UnlocatedStore;
import client.view.ItemList;
import client.view.PanelListe;
import client.view.PanelLocations;
import common.Emplacement;
import common.Magasin;


/**
 * Application Tab for Location & store mapping
 * 
 *
 */
public class AppGestionEmplacement {
	private JPanel tabPanel;							// Jpanel Tab of this app
	private PanelLocations panelLoc;
	private PanelListe panelStores;
	private Query qManager;								// query manager (DTO) of the main app
	private ArrayList<UnlocatedStore> unlocatedStore;	// Stores without location from csv
	private ArrayList<UnlocatedStore> restUnlocated;	// Stores without location after algorithm
	private ArrayList<UnlocatedStore> tmpUnlocated;		// Stores without location after algorithm (temporary list)
	private ArrayList<Magasin> locatedStores;			// Stores with new location
	private ArrayList<Emplacement> emptyLocations;		// Empty location of the Mall
	private ArrayList<Emplacement> restEmptyLocations;	// Empty location of the Mall after algorithm
	private ArrayList<Emplacement> tmpEmptyLocations;	// Empty location of the Mall after algorithm (temporary list)
	private ArrayList<Emplacement> locations;			// All location of the Mall
	private EmplacementDTO empDTO;						// location DTO
	private ClientMagasinDAO magDTO;					// magasin DTO
	private JFileChooser dialogue;
	private String csv;
	private JLabel errorLabel;
	
	
	public AppGestionEmplacement(JPanel tabPanel,Query q){
		
		//***************** GUI Tab panel initialization *****************
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelLoc = new PanelLocations();
		panelStores = new PanelListe();
		this.tabPanel.add(panelStores,BorderLayout.WEST);
		JScrollPane scroll = new JScrollPane(panelStores);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.tabPanel.add(panelLoc,BorderLayout.SOUTH);
		panelStores.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tabPanel.add(scroll,BorderLayout.WEST);
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		tabPanel.add(errorLabel,BorderLayout.CENTER);
		
		
		
		//*****************GUI Top bar and options*****************
		
		JPanel searchBar = new JPanel();
		searchBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchBar.setPreferredSize(new Dimension(600, 40));
		Border border = searchBar.getBorder();
		Border margin = new EmptyBorder(0,0,10,0);
		searchBar.setBorder(new CompoundBorder(border, margin));
		searchBar.add(new JLabel("Fichier CSV "));
		JTextField fileName = new JTextField("Select csv file");
		fileName.setPreferredSize(new Dimension(200,24));
		searchBar.add(fileName);
		JButton selectFileButton = new JButton("Selectioner");
		dialogue = new JFileChooser();
		selectFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogue.showOpenDialog(null);
				csv = dialogue.getSelectedFile().getAbsolutePath();
				fileName.setText(csv);
				//Read CSV file with unlocated stores
				unlocatedStore = readUnlocatedStoresCSVFile(csv);
				updateStoresList(unlocatedStore);
			}
		});
		searchBar.add(selectFileButton);
		
		JButton mappingButton = new JButton("Placer les magasins");
		mappingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emptyLocations = empDTO.getEmptyEmplacement();
				startMapping();
				errorLabel.setText(restUnlocated.size()+" Magasins ne peuvent pas être placés !");
			}
		}); 
		searchBar.add(mappingButton);
		
		tabPanel.add(searchBar,BorderLayout.NORTH);
		
		//*******************************************************
		
		
		// DTO initialization
		this.qManager = q;
		empDTO = new EmplacementDTO(qManager);
		magDTO = new ClientMagasinDAO(qManager);
		

		
		//Load all locations
		locations = empDTO.getAllEmplacement();
		
		//Load empty locations
		emptyLocations = empDTO.getEmptyEmplacement();
        
		
		for(Emplacement e : locations){
			panelLoc.addLocation(e.getId());
		}
		for(Emplacement e : emptyLocations){
			panelLoc.setLocationEmpty(e.getId());
		}

	}
	
	
	public void startMapping(){
		restUnlocated = new ArrayList<>();
		locatedStores = setStoreLocation();
		restUnlocated = tmpUnlocated;
		
		//If some stores are not located, the list of Stores is shuffle and the algorithm is run 1000x 
		//This random solver increase the chance to find the best location of each store
		if(locatedStores.size() != unlocatedStore.size()){
			ArrayList<Magasin> tmp = new ArrayList<>();
			for(int i=0; i<1000; i++){
				Collections.shuffle(unlocatedStore);
				tmp = setStoreLocation();
				if(tmp.size() > locatedStores.size()){
					locatedStores = tmp;
					restUnlocated = tmpUnlocated;
					restEmptyLocations = tmpEmptyLocations;
				}
			}
		}
		createStoresDB(locatedStores);
	}
	
	
	public void createStoresDB(ArrayList<Magasin> storesList){
		for(Magasin m : storesList){
			magDTO.create(m);
			panelLoc.setLocationFull(m.getIdEmplacement(),m.getNom());
		}
		updateStoresList(restUnlocated);
	}
	

	public ArrayList<Magasin> setStoreLocation(){
		tmpUnlocated = new ArrayList<>();
		ArrayList<Magasin> list = new ArrayList<>();
		Deque<Emplacement> rest = new LinkedList<>(emptyLocations);
		ArrayList<Emplacement> selectedLoc = new ArrayList<>();
	
		// For each store, trying to get a selection of locations according the parameters (area,isRestaurant,exitOption)
		for(UnlocatedStore us : unlocatedStore){
			selectedLoc = new ArrayList<>(); //Flush selection
			//For each not used location
			for(Emplacement e : rest){
				//If:  areaLoc-20% < store area need < areaLoc+20%
				if(  (e.getArea()-(e.getArea()*0.2) <= us.getArea()) && (e.getArea()+(e.getArea()*0.2) >= us.getArea())  ){
					//If: Store is restaurant type AND if the location is in the restaurant space
					if(us.getType() == 24 && e.getZone().getId() == 8){
						selectedLoc.add(e);
					}else if(us.getType() != 24 && us.getExitOption() == 1 && e.getExitDistance() < 6 && e.getZone().getId() != 8){
						selectedLoc.add(e);
					}else if(us.getType() != 24 && us.getExitOption() == 0 && e.getZone().getId() != 8){
						selectedLoc.add(e);
					}
				}
			}
			
			//Trying to get the best location from the first selection
			if(!selectedLoc.isEmpty()){
				int gapi,gapj = 0;
				Emplacement tmp;
				if(selectedLoc.size()>1){
					for(int i=0; i<selectedLoc.size(); i++){
						for(int j=1; j<selectedLoc.size();j++){	
							gapi =  Math.abs((us.getArea()-selectedLoc.get(i).getArea()));
							gapj =  Math.abs((us.getArea()-selectedLoc.get(j).getArea()));
							if(gapj<=gapi){ 												//Compare area gap between locations
								tmp = selectedLoc.get(j);									//The location with the smaller gap is set to the beginning of the list
								selectedLoc.set(j, selectedLoc.get(i));
								selectedLoc.set(i, tmp);
							}
						}
					}
				}
				list.add(new Magasin(0, "none", us.getName(), "none", selectedLoc.get(0).getId(), us.getType()));
				rest.remove(selectedLoc.get(0));
			}else{
				//Store cannot be placed into a location
				tmpUnlocated.add(us);
			}
		}
		tmpEmptyLocations = new ArrayList<>(rest);
		return list;
	}
	
	
	/**
	 * @param csvFile
	 * @return ArrayList<UnlocatedStore>
	 * 
	 * Read CSV file with unlocated stores and return them into UnlocatedStore ArrayList
	 */
	public ArrayList<UnlocatedStore> readUnlocatedStoresCSVFile(String csvFile){
		ArrayList<UnlocatedStore> list = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use ';' as separator
                String[] mag = line.split(cvsSplitBy);
                    list.add(new UnlocatedStore(mag[0],Integer.parseInt(mag[2]), Integer.parseInt(mag[1]), Integer.parseInt(mag[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
	}
	
	
	public void updateStoresList(ArrayList<UnlocatedStore> list){
		panelStores.removeAll();
		int px = 1;
		for(UnlocatedStore u : list){
			ItemList i = new ItemList(u.getName()+" | "+u.getArea()+"m2"+" | Porte :"+u.getExitOption());
			i.setMaximumSize(new Dimension(300, 37));
			px++;
			panelStores.add(i);
		}
		panelStores.setPreferredSize(new Dimension(300, px*37));
		panelStores.revalidate();
		panelStores.repaint();
	}
	
}
