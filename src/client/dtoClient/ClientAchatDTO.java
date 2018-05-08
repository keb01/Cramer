package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Achat;
import common.Borne;
import common.Fournisseur;
import common.Magasin;
import common.Personne;

public class ClientAchatDTO extends ClientDAO<Achat> {
	private Query queryManager;
    
    public ClientAchatDTO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public Achat find(long id) {
		return null;
	}

	@Override
	public Achat create(Achat obj) {
		
				queryManager.setQueryType("INSERT");
				queryManager.setTable("ACHAT");
				queryManager.setParam("{\"id\":"+obj.idFournisseur+",\"total\":"+obj.total+"}");
				
				//queryManager.getParam().get(0)=Long.toString(obj.getId());
				//queryManager.getParam().get(1)=Long.toString(obj.getZone().getId());
				
				String response = queryManager.executeQuery();
				
				return obj;
	}

	@Override
	public Achat  update(Achat  obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Achat  obj) {
		// TODO Auto-generated method stub
		
	}
    
	public ArrayList<Achat> getAllAchats() {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ACHAT");
		queryManager.setParam("{}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Achat> listAchats = new ArrayList<Achat>();
		
		try {
			Achat[] tab = objectMapper.readValue(answer, Achat[].class);
			listAchats = new ArrayList<Achat>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listAchats;
		
	}
}
