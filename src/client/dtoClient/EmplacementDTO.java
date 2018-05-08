package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.codehaus.jackson.map.ObjectMapper;
import common.Emplacement;
import common.Zone;



public class EmplacementDTO extends ClientDAO<Emplacement> {
	private Query queryManager;
    private ClientDAO<Zone> clientZoneDAO;
    
    public EmplacementDTO(Query q) {
		this.queryManager = q;
		clientZoneDAO = new ClientZoneDAO(this.queryManager);
				
	}

	@Override
	public Emplacement find(long id) {
		//ArrayList unusual
		
				queryManager.setQueryType("FIND");
				queryManager.setTable("EMPLACEMENT");
				queryManager.setParam("{\"id\":\""+Long.toString(id)+"\"}");
				String response = queryManager.executeQuery();
				
				ObjectMapper objectMapper = new ObjectMapper();
				Emplacement emp = new Emplacement();
				
				try {
					emp = objectMapper.readValue(response, Emplacement.class);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return emp;
	}

	@Override
	public Emplacement create(Emplacement obj) {
		//ArrayList unusual
		
				queryManager.setQueryType("INSERT");
				queryManager.setTable("EMPLACEMENT");
				queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"price\":"+Double.toString(obj.getPrice())+",\"area\":"+obj.getArea()+",\"exitDistance\":"+obj.getExitDistance()+",\"idZone\":"+Long.toString(obj.getZone().getId())+"}");
				
				//queryManager.getParam().get(0)=Long.toString(obj.getId());
				//queryManager.getParam().get(1)=Long.toString(obj.getZone().getId());
				
				String response = queryManager.executeQuery();
				
				return obj;
	}

	@Override
	public Emplacement update(Emplacement obj) {
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("EMPLACEMENT");
		queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"price\":"+Double.toString(obj.getPrice())+",\"area\":"+obj.getArea()+",\"exitDistance\":"+obj.getExitDistance()+",\"idZone\":"+Long.toString(obj.getZone().getId())+"}");
		
		//queryManager.getParam().get(0)=Long.toString(obj.getId());
		//queryManager.getParam().get(1)=Long.toString(obj.getZone().getId());
		
		String response = queryManager.executeQuery();
		
		return obj;
		
	}

	@Override
	public void delete(Emplacement obj) {
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("EMPLACEMENT");
		queryManager.setParam("{\"id\":\""+Long.toString(obj.getId())+"\"}");
		
		//queryManager.getParam().get(0)=Long.toString(idBorne);
		//queryManager.getParam().get(1)=Long.toString(idZone);
		
		String response = queryManager.executeQuery();
		
	
		
	}




//***********************************************************************************************************************
	
public ArrayList<Emplacement> getAllEmplacement(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("EMPLACEMENT");
		queryManager.setParam("{\"type\":\"FULL\"}");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Emplacement> listEmplacement = new ArrayList<Emplacement>();
		
		try {
			Emplacement[] array = objectMapper.readValue(response, Emplacement[].class);
			listEmplacement = new ArrayList<Emplacement>(Arrays.asList(array));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listEmplacement;

	}
public ArrayList<Emplacement> getEmptyEmplacement(){
	
	queryManager.setQueryType("LIST");
	queryManager.setTable("EMPLACEMENT");
	queryManager.setParam("{\"type\":\"EMPTY\"}");
	String response = queryManager.executeQuery();
	
	ObjectMapper objectMapper = new ObjectMapper();
	ArrayList<Emplacement> listEmplacement = new ArrayList<Emplacement>();
	
	try {
		Emplacement[] array = objectMapper.readValue(response, Emplacement[].class);
		listEmplacement = new ArrayList<Emplacement>(Arrays.asList(array));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return listEmplacement;

}

}

