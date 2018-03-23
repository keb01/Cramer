package DAOClient;

import Model.Zone;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.codehaus.jackson.map.ObjectMapper;

public class ClientZoneDAO extends ClientDAO<Zone>{
	private Query queryManager;

	public ClientZoneDAO(Query q){
		this.queryManager = q;
	}

	//*****************************************Extended methods of DAO*********************************************************

	@Override
	public Zone find(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zone create(Zone obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zone update(Zone obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Zone obj) {
		// TODO Auto-generated method stub

	}

	//*************************************************************************************************************************


	public ArrayList<Zone> getAllZones(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ZONE");
		queryManager.setParam("");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Zone> listZone = new ArrayList<Zone>();
		
		try {
			Zone[] tab = objectMapper.readValue(response, Zone[].class);
			listZone = new ArrayList<Zone>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listZone;

	}


	public ArrayList<Zone> getZoneIdX(long id){
		
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("ZONE");
		queryManager.setParam(Long.toString(id));
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Zone> listZone = new ArrayList<Zone>();
		
		try {
			Zone[] tab = objectMapper.readValue(response, Zone[].class);
			listZone = new ArrayList<Zone>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listZone;

	}


}
