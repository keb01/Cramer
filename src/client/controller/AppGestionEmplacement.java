package client.controller;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.JPanel;

import org.codehaus.jackson.map.ser.impl.UnknownSerializer;

import com.mysql.fabric.xmlrpc.base.Array;

import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.EmplacementDTO;
import client.dtoClient.Query;
import client.model.UnlocatedStore;
import common.Emplacement;
import common.Magasin;


/**
 * Application Tab for Location & store mapping
 * 
 *
 */
public class AppGestionEmplacement {
	private JPanel tabPanel;							// Jpanel Tab of this app
	private Query qManager;								// query manager (DTO) of the main app
	private ArrayList<UnlocatedStore> unlocatedStore;	// Stores without location from csv
	private ArrayList<UnlocatedStore> restUnlocated;	// Stores without location after algorithm
	private ArrayList<UnlocatedStore> tmpUnlocated;	// Stores without location after algorithm (temporary list)
	private ArrayList<Magasin> locatedStores;			// Stores with new location
	private ArrayList<Emplacement> emptyLocations;		// Empty location of the Mall
	private ArrayList<Emplacement> locations;			// All location of the Mall
	private EmplacementDTO empDTO;						// location DTO
	private ClientMagasinDAO magDTO;					// magasin DTO
	
	public AppGestionEmplacement(JPanel tabPanel,Query q){
		
		// GUI Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		
		// DTO initialization
		this.qManager = q;
		empDTO = new EmplacementDTO(qManager);
		magDTO = new ClientMagasinDAO(qManager);
		
		//Read CSV file with unlocated stores
		unlocatedStore = readUnlocatedStoresCSVFile("MagasinAPlacer.csv");
		
		//Load all locations
		locations = empDTO.getAllEmplacement();
		
		//Load empty locations
		emptyLocations = empDTO.getEmptyEmplacement();
        
		//magDTO.create(new Magasin(1, "tot", "Carrefour", "Grande surface", 8, 24));	
		
		locatedStores = setStoreLocation();
		restUnlocated = new ArrayList<>();
		if(locatedStores.size() != unlocatedStore.size()){
			ArrayList<Magasin> tmp = new ArrayList<>();
			for(int i=0; i<1000; i++){
				Collections.shuffle(unlocatedStore);
				tmp = setStoreLocation();
				if(tmp.size() > locatedStores.size()){
					locatedStores = tmp;
					restUnlocated = new ArrayList<>(tmpUnlocated);
				}
			}
		}		
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
							if(gapj<=gapi){
								tmp = selectedLoc.get(j);
								selectedLoc.set(j, selectedLoc.get(i));
								selectedLoc.set(i, tmp);
							}
						}
					}
				}
				list.add(new Magasin(0, "", us.getName(), "toto", selectedLoc.get(0).getId(), us.getType()));
				rest.remove(selectedLoc.get(0));
				//System.out.println("---CHOIX Emplacement "+selectedLoc.get(0).getId()+" Taille : "+selectedLoc.get(0).getArea()+" Sortie"+selectedLoc.get(0).getExitDistance());

			}else{
				//Store cannot be placed into a location
				tmpUnlocated.add(us);
			}
		}
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
	
}
