package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Magasin;
import common.Personne;

public class ClientMagasinDAO extends ClientDAO<Magasin> {
	private Query queryManager;
    
    public ClientMagasinDAO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public Magasin find(long id) {
			//ArrayList unusual
			
			queryManager.setQueryType("FIND");
			queryManager.setTable("MAGASIN");
			queryManager.setParam("{\"id\":"+id+"}");
			
			
			String answer = queryManager.executeQuery();
			ObjectMapper objectMapper = new ObjectMapper();
			Magasin obja = new Magasin();
			
			try {
				obja = objectMapper.readValue(answer, Magasin.class);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return obja;
		
	}

	@Override
	public Magasin create(Magasin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Magasin update(Magasin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Magasin obj) {
		// TODO Auto-generated method stub
		
	}
    
	public ArrayList<Magasin> getAllMagasins() {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("MAGASIN");
		queryManager.setParam("{}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Magasin> listMagasin = new ArrayList<Magasin>();
		
		try {
			Magasin[] tab = objectMapper.readValue(answer, Magasin[].class);
			listMagasin = new ArrayList<Magasin>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listMagasin;
		
	}
}