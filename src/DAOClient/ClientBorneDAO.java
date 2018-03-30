package DAOClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import Model.*;


public class ClientBorneDAO extends ClientDAO<Borne> {
	private Query queryManager;
    private ClientDAO<Zone> clientZoneDAO;
    
    public ClientBorneDAO(Query q) {
		this.queryManager = q;
		clientZoneDAO = new ClientZoneDAO(this.queryManager);
				
	}

	@Override
	public Borne find(long id) {
		//ArrayList unusual
		
				queryManager.setQueryType("FIND");
				queryManager.setTable("BORNE");
				queryManager.setParam("{\"id\":\""+Long.toString(id)+"\"}");
				String response = queryManager.executeQuery();
				
				ObjectMapper objectMapper = new ObjectMapper();
				Borne borne = new Borne();
				
				try {
					borne = objectMapper.readValue(response, Borne.class);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				return borne;
	}

	@Override
	public Borne create(Borne obj) {
		//ArrayList unusual
		
				queryManager.setQueryType("INSERT");
				queryManager.setTable("BORNE");
				queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"idZone\":"+Long.toString(obj.getZone().getId())+"}");
				
				//queryManager.getParam().get(0)=Long.toString(obj.getId());
				//queryManager.getParam().get(1)=Long.toString(obj.getZone().getId());
				
				String response = queryManager.executeQuery();
				
				return obj;
	}

	@Override
	public Borne update(Borne obj) {
		
		queryManager.setQueryType("UPDATE");
		queryManager.setTable("BORNE");
		queryManager.setParam("{\"id\":"+Long.toString(obj.getId())+",\"idZone\":"+Long.toString(obj.getZone().getId())+"}");
		
		//queryManager.getParam().get(0)=Long.toString(obj.getId());
		//queryManager.getParam().get(1)=Long.toString(obj.getZone().getId());
		
		String response = queryManager.executeQuery();
		
		return obj;
		
	}

	@Override
	public void delete(Borne obj) {
		
		queryManager.setQueryType("DELETE");
		queryManager.setTable("BORNE");
		queryManager.setParam("{\"id\":\""+Long.toString(obj.getId())+"\"}");
		
		//queryManager.getParam().get(0)=Long.toString(idBorne);
		//queryManager.getParam().get(1)=Long.toString(idZone);
		
		String response = queryManager.executeQuery();
		
	
		
	}




//***********************************************************************************************************************
	
public ArrayList<Borne> getAllBornes(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("BORNE");
		queryManager.setParam("{}");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Borne> listBorne = new ArrayList<Borne>();
		
		try {
			Borne[] array = objectMapper.readValue(response, Borne[].class);
			listBorne = new ArrayList<Borne>(Arrays.asList(array));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listBorne;

	}


	public Borne getBorneIdX(long id){
		//ArrayList unusual
		
		queryManager.setQueryType("FIND");
		queryManager.setTable("BORNE");
		queryManager.setParam("{\"id\":\""+Long.toString(id)+"\"}");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		Borne borne = new Borne();
		
		try {
			borne = objectMapper.readValue(response, Borne.class);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return borne;

	}
	
	public void createBorne(long idBorne, long idZone){
		//ArrayList unusual
		
		queryManager.setQueryType("INSERT");
		queryManager.setTable("BORNE");
		queryManager.setParam("{\"id\":"+Long.toString(idBorne)+",\"idZone\":"+Long.toString(idZone)+"}");
		
		//queryManager.getParam().get(0)=Long.toString(idBorne);
		//queryManager.getParam().get(1)=Long.toString(idZone);
		
		String response = queryManager.executeQuery();
		
		

	}


}

/*
    public Borne findInBorne(long id, long idZone) {


        return borne;
    }

    public ArrayList<Borne> getAllBornes(){

        ArrayList<Borne> liste = new ArrayList<Borne>();


        Statement st = null;
        ResultSet rs = null;


        try {
            st = this.connect.createStatement();
            String sql = "SELECT * FROM Borne ";
            rs = st.executeQuery(sql);

            while(rs.next()) {
                liste.add(new Borne(rs.getInt("id"),
                        DAOzone.find(rs.getInt("idZone"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

*/

