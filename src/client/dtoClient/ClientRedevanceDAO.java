package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.*;

public class ClientRedevanceDAO extends ClientDAO<Redevance>{
	private Query queryManager;

	public ClientRedevanceDAO(Query q){
		this.queryManager = q;
	}

	//*****************************************Extended methods of DAO*********************************************************

	@Override
	public Redevance find(long id) {
		//ArrayList unusual
		
				queryManager.setQueryType("FIND");
				queryManager.setTable("REDEVANCE");
				queryManager.setParam("{\"id_redevance\":\""+Long.toString(id)+"\"}");
				String answer = queryManager.executeQuery();
				
				ObjectMapper objectMapper = new ObjectMapper();
				Redevance redevance = new Redevance();
				
				try {
					redevance = objectMapper.readValue(answer, Redevance.class);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return redevance;
	}

	@Override
	public Redevance create(Redevance obj){
		
		queryManager.setQueryType("INSERT");
		queryManager.setTable("REDEVANCE");
		queryManager.setParam("{\"id_redevance\":"+Long.toString(obj.getId_redevance())+",\"id_magasin\":\""+obj.getId_magasin()+"\",\"nom_magasin\":\""+obj.getNom_magasin()+"\",\"montant_redevance\":"+obj.getMontant_redevance()+"\",\"date_redevance\":\"+obj.getDate_redevance()+\"}");	
		
		String answer = queryManager.executeQuery();
		
		return obj;
	}


	@Override
	public Redevance update(Redevance obj){
		//ArrayList unusual
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("REDEVANCE");
		queryManager.setParam("{\"id_redevance\":"+Long.toString(obj.getId_redevance())+",\"id_magasin\":\""+obj.getId_magasin()+"\",\"nom_magasin\":\""+obj.getNom_magasin()+"\",\"montant_redevance\":"+obj.getMontant_redevance()+"\",\"date_redevance\":\"+obj.getDate_redevance()+\"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;

	}
	
	
	@Override
	public void delete(Redevance obj){
		//ArrayList unusual
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("REDEVANCE");
		queryManager.setParam("{\"id_redevance\":\""+Long.toString(obj.getId_redevance())+"\"}");
		
		String answer = queryManager.executeQuery();
		
		

	}

	//*************************************************************************************************************************


	public ArrayList<Redevance> getAllRedevances(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("REDEVANCE");
		queryManager.setParam("{}");
		String answer = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Redevance> listRedevance = new ArrayList<Redevance>();
		
		try {
			Redevance[] tab = objectMapper.readValue(answer, Redevance[].class);
			listRedevance = new ArrayList<Redevance>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listRedevance;

	}


	

}

