package DAOClient;

import Model.Zone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		ArrayList<Zone> listZone = new ArrayList<Zone>();
		queryManager.setQueryType("LIST");
		queryManager.setTable("ZONE");
		queryManager.setParam("");
		queryManager.executeQuery();

		return listZone;

	}




}
