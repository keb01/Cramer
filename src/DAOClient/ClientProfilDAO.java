package DAOClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import Model.*;


public class ClientProfilDAO extends ClientDAO<Profil> {
	private Query queryManager;
    
    public ClientProfilDAO(Query q) {
		this.queryManager = q;		
	}
    
	public Profil update(Profil obj){
		//ArrayList unusual
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("PROFIL");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"nomProfil\":\""+obj.getNomProfil()+"\"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;

	}

	public Profil create(Profil obj){
		//ArrayList unusual
		
		queryManager.setQueryType("INSERT");
		queryManager.setTable("PROFIL");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"nomProfil\":\""+obj.getNomProfil()+"\"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;
	}
	
	public Profil find(long obj){
		//ArrayList unusual
		
		queryManager.setQueryType("FIND");
		queryManager.setTable("PROFIL");
		queryManager.setParam("{ \"id\":"+obj+"}");
		
		
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		Profil obja = new Profil();
		
		try {
			obja = objectMapper.readValue(answer, Profil.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return obja;
	}
	
	public void delete(Profil obj){
		//ArrayList unusual
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("PROFIL");
		queryManager.setParam("{ \"id\":"+obj.getId()+"}");
		
		
		String answer = queryManager.executeQuery();
		
	}	
	
    
}