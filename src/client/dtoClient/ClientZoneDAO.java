package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.codehaus.jackson.map.ObjectMapper;

import common.Borne;
import common.Zone;

public class ClientZoneDAO extends ClientDAO<Zone>{
	private Query queryManager;

	public ClientZoneDAO(Query q){
		this.queryManager = q;
	}

	//*****************************************Extended methods of DAO*********************************************************

	@Override
	public Zone find(long id) {
		//ArrayList unusual
		
				queryManager.setQueryType("FIND");
				queryManager.setTable("ZONE");
				queryManager.setParam("{\"id\":\""+Long.toString(id)+"\"}");
				String answer = queryManager.executeQuery();
				
				ObjectMapper objectMapper = new ObjectMapper();
				Zone zone = new Zone();
				
				try {
					zone = objectMapper.readValue(answer, Zone.class);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return zone;
	}

	@Override
	public Zone create(Zone obj){
		
		queryManager.setQueryType("INSERT");
		queryManager.setTable("ZONE");
		queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"nom\":\""+obj.getNom()+"\",\"description\":\""+obj.getDescription()+"\",\"coefP\":"+obj.getCoefP()+"}");
		
		
		//queryManager.getParam().get(0)=Long.toString(idZone);
		
		String answer = queryManager.executeQuery();
		
		return obj;
	}


	@Override
	public Zone update(Zone obj){
		//ArrayList unusual
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("ZONE");
		queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"nom\":\""+obj.getNom()+"\",\"description\":\""+obj.getDescription()+"\",\"coefP\":"+obj.getCoefP()+"}");
		
		
		String answer = queryManager.executeQuery();
		
		return obj;

	}
	
	
	@Override
	public void delete(Zone obj){
		//ArrayList unusual
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("ZONE");
		queryManager.setParam("{\"id\":\""+Long.toString(obj.getId())+"\"}");
		
		String answer = queryManager.executeQuery();
		
		

	}

	//*************************************************************************************************************************


	public ArrayList<Zone> getAllZones(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ZONE");
		queryManager.setParam("{}");
		String answer = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Zone> listZone = new ArrayList<Zone>();
		
		try {
			Zone[] tab = objectMapper.readValue(answer, Zone[].class);
			listZone = new ArrayList<Zone>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listZone;

	}


	public Zone getZoneIdX(long id){
		//ArrayList unusual
		
		queryManager.setQueryType("FIND");
		queryManager.setTable("ZONE");
		queryManager.setParam("{\"id\":\""+Long.toString(id)+"\"}");
		String answer = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		Zone zone = new Zone();
		
		try {
			zone = objectMapper.readValue(answer, Zone.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return zone;

	}

}
