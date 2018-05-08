package client.controller;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import client.dtoClient.Query;


public class AppGestionEmplacement {
	private JPanel tabPanel;
	//private Query qManager;

	
	public AppGestionEmplacement(JPanel tabPanel,Query q){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		
		
		
		String csvFile = "MagasinAPlacer.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use ';' as separator
                String[] mag = line.split(cvsSplitBy);

                System.out.println(mag[0] + " " + mag[1] + " " + mag[2] + " " + mag[3]);

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
		
				
		
		// DAOs initialization
		//this.qManager = q;

			
	}
	
	
	
}
