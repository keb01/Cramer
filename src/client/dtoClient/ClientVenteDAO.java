package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Profil;
import common.Vente;
import common.Zone;
import server.model.CategorieMagasin;

public class ClientVenteDAO extends ClientDAO<Vente>{

	private Query queryManager;
    
    public ClientVenteDAO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public Vente find(long id) {
		queryManager.setQueryType("FIND");
		queryManager.setTable("VENTE");
		queryManager.setParam("{ \"id\":"+id+"}");
		
		
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		Vente obja = new Vente();
		
		try {
			obja = objectMapper.readValue(answer, Vente.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return obja;
	}

	@Override
	public Vente create(Vente obj) {
		queryManager.setQueryType("INSERT");
		queryManager.setTable("VENTE");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"idArticle\":"+obj.getIdArticle()+",\"idEmploye\":"+obj.getIdEmploye()+",\"idClient\":"+obj.getIdClient()+",\"quantite\":"+obj.getQuantite()+",\"prix\":"+obj.getPrix()+",\"dateVente\":"+obj.getDateVente()+"}");
		String answer = queryManager.executeQuery();
		
		return obj;
	}

	@Override
	public Vente update(Vente obj) {
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("VENTE");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"idArticle\":"+obj.getIdArticle()+",\"idEmploye\":"+obj.getIdEmploye()+",\"idClient\":"+obj.getIdClient()+",\"quantite\":"+obj.getQuantite()+",\"prix\":"+obj.getPrix()+",\"dateVente\":"+obj.getDateVente()+"}");
		String answer = queryManager.executeQuery();
		
		return obj;
	}

	@Override
	public void delete(Vente obj) {
		queryManager.setQueryType("DELETE");
		queryManager.setTable("PROFIL");
		queryManager.setParam("{ \"id\":"+obj.getId()+"}");
		
		
		String answer = queryManager.executeQuery();
	}
	
	public CategorieMagasin findCategorieMagasinVenteX(long id) {
		queryManager.setQueryType("FIND");
		queryManager.setTable("CATEGORIEVENTEX");
		queryManager.setParam("{ \"id\":"+id+"}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		CategorieMagasin obja = new CategorieMagasin();
		
		try {
			obja = objectMapper.readValue(answer, CategorieMagasin.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return obja;
	}
	
	public ArrayList<Vente> getAllVentesClientX(long id){
		queryManager.setQueryType("LIST");
		queryManager.setTable("VENTECLIENTX");
		queryManager.setParam("{ \"id\":"+id+"}");
		String answer = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Vente> listVente = new ArrayList<Vente>();
		
		try {
			Vente[] tab = objectMapper.readValue(answer, Vente[].class);
			listVente = new ArrayList<Vente>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listVente;
	}
    
	
}
