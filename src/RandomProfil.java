import java.util.ArrayList;
import java.util.Random;

import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.ClientPersonneDAO;
import client.dtoClient.ClientProfilDAO;
import client.dtoClient.Query;
import common.Personne;
import common.Profil;

public class RandomProfil {
	
	public static void main (String []args){
		
		Query qManager = new Query();
		ClientPersonneDAO clientPersonneDAO = new ClientPersonneDAO(qManager);
		ClientProfilDAO profilDAO = new ClientProfilDAO(qManager);
		ArrayList<Personne> listeClient = clientPersonneDAO.getAllClients(); 
		ArrayList<Profil> listeProfil= profilDAO.getAllProfils();
		
		for (int i =0 ; i< listeClient.size()-1; i++) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt(listeProfil.size()-1) + 1;
		
		listeClient.get(i).setIdProfil(randomNum);
		
		clientPersonneDAO.updateProfil(listeClient.get(i));
		
		
		}
	}
}
