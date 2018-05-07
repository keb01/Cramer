package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Fournisseur;
import common.Magasin;
import common.Personne;

public class ClientFournisseurDTO extends ClientDAO<Fournisseur> {
	private Query queryManager;
    
    public ClientFournisseurDTO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public Fournisseur find(long id) {
		return null;
	}

	@Override
	public Fournisseur create(Fournisseur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur update(Fournisseur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Fournisseur obj) {
		// TODO Auto-generated method stub
		
	}
    
	public ArrayList<Fournisseur> getAllFournisseurs() {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("FOURNISSEUR");
		queryManager.setParam("{}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
		
		try {
			Fournisseur[] tab = objectMapper.readValue(answer, Fournisseur[].class);
			listFournisseurs = new ArrayList<Fournisseur>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listFournisseurs;
		
	}
}