package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Personne;



public class ClientPersonneDAO extends ClientDAO<Personne> {
	private Query queryManager;
    
    public ClientPersonneDAO(Query q) {
		this.queryManager = q;		
	}
    
	public Personne update(Personne obj){
		//ArrayList unusual
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("PERSONNE");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"nom\":\""+obj.getNom()+"\", \"prenom\":\""+obj.getPrenom()+"\", \"age\":"+obj.getAge()+", \"adresse\":\""+obj.getAdresse()+"\", \"codePostal\":"+obj.getCodePostal()+", \"ville\":\""+obj.getVille()+"\" , \"idProfil\":"+obj.getIdProfil()+"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;

	}

	public Personne create(Personne obj){
		//ArrayList unusual
		
		queryManager.setQueryType("INSERT");
		queryManager.setTable("PERSONNE");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"nom\":\""+obj.getNom()+"\", \"prenom\":\""+obj.getPrenom()+"\", \"age\":"+obj.getAge()+", \"adresse\":\""+obj.getAdresse()+"\", \"codePostal\":"+obj.getCodePostal()+", \"ville\":\""+obj.getVille()+"\" , \"idProfil\":"+obj.getIdProfil()+"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;
	}
	
	public Personne find(long obj){
		//ArrayList unusual
		
		queryManager.setQueryType("FIND");
		queryManager.setTable("PERSONNE");
		queryManager.setParam("{ \"id\":"+obj+"}");
		
		
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		Personne obja = new Personne();
		
		try {
			obja = objectMapper.readValue(answer, Personne.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return obja;
	}
	
	public void delete(Personne obj){
		//ArrayList unusual
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("PERSONNE");
		queryManager.setParam("{ \"id\":"+obj.getId()+"}");
		
		
		String answer = queryManager.executeQuery();
		
	}	
	
	public Personne updateProfil(Personne obj){
		//ArrayList unusual
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("PERSONNEPROFIL");
		queryManager.setParam("{ \"id\":"+obj.getId()+", \"nom\":\" \", \"prenom\":\" \", \"age\":0, \"adresse\":\" \", \"codePostal\":0, \"ville\":\" \",\"idProfil\":"+obj.getIdProfil()+"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;

	}
	
	public ArrayList<Personne> getAllClients(){
			System.out.println("ICI");
			queryManager.setQueryType("LIST");
			queryManager.setTable("CLIENT");
			queryManager.setParam("{}");
			String response = queryManager.executeQuery();
			
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayList<Personne> listClient = new ArrayList<Personne>();
			
			try {
				Personne[] array = objectMapper.readValue(response, Personne[].class);
				listClient = new ArrayList<Personne>(Arrays.asList(array));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return listClient;

		}
    
	public ArrayList<Personne> getAllEmployes(){
		queryManager.setQueryType("LIST");
		queryManager.setTable("EMPLOYE");
		queryManager.setParam("{}");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Personne> list = new ArrayList<>();
		
		try {
			Personne[] array = objectMapper.readValue(response, Personne[].class);
			list = new ArrayList<Personne>(Arrays.asList(array));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;

	}
}