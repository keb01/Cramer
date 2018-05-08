package client.controller;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import client.dtoClient.Query;


public class AppGestionEmplacement {
	private JPanel tabPanel;
	//private Query qManager;

	
	public AppGestionEmplacement(JPanel tabPanel,Query q){
		
		// Tab panel initialization 
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		
				
		
		// DAOs initialization
		//this.qManager = q;

			
	}
	
	
	
}
