package client.controller;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
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
	private ArrayList<Magasin> locatedStores;			// Stores with new location
	private ArrayList<Emplacement> emptyLocations;		// Empty location of the Mall
	private ArrayList<Emplacement> locations;			// All location of the Mall
	private EmplacementDTO empDTO;						// location DTO

	
	public AppGestionEmplacement(JPanel tabPanel,Query q){
		
		// GUI Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		
		// DTO initialization
		this.qManager = q;
		empDTO = new EmplacementDTO(qManager);
		
		//Read CSV file with unlocated stores
		unlocatedStore = readUnlocatedStoresCSVFile("MagasinAPlacer.csv");
		
		//Load all locations
		locations = empDTO.getAllEmplacement();
		
		//Load empty locations
		emptyLocations = empDTO.getEmptyEmplacement();
        
				
		
		/*
		for(Emplacement e : locations){
			System.out.println("ID :"+e.getId()+" Price : "+e.getPrice()+" Area : "+e.getArea()+" Zone : "+e.getZone().getNom()+" distancePorte : "+e.getExitDistance());
		}
		for(Emplacement e : emptyLocations){
			System.out.println("ID :"+e.getId()+" Price : "+e.getPrice()+" Area : "+e.getArea()+" Zone : "+e.getZone().getNom()+" distancePorte : "+e.getExitDistance());
		}
		 */
			
	}
	
	
	
	
	public ArrayList<Magasin> setStoreLocation(){
		ArrayList<Magasin> list = new ArrayList<>();
		
		
		
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
