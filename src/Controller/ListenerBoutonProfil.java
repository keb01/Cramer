package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import DAOClient.ClientPersonneDAO;
import Model.Personne;

public class ListenerBoutonProfil implements ActionListener {

	
	private AppGestionProfil c;
	private ArrayList<Personne> m;
	private ClientPersonneDAO dao;
	
	public ListenerBoutonProfil(AppGestionProfil c, ArrayList<Personne> m,ClientPersonneDAO dao) {
	this.c = c;
	this.m=m;
	this.dao=dao;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for (int i =0 ; i< m.size()-1; i++) {
			
			Random rand = new Random();
			int randomNum = rand.nextInt(10);
			
			m.get(i).setIdProfil(randomNum);
			
			this.dao.updateProfil(m.get(i));
			
			//c.updatePanelProfil();
		}
		

	}

}
