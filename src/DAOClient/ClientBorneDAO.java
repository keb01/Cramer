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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borne create(Borne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borne update(Borne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Borne obj) {
		// TODO Auto-generated method stub
		
	}




//***********************************************************************************************************************
	
public ArrayList<Borne> getAllBornes(){
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("Borne");
		queryManager.setParam("");
		String response = queryManager.executeQuery();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Borne> listBorne = new ArrayList<Borne>();
		
		try {
			Zone[] tab = objectMapper.readValue(response, Zone[].class);
			listBorne = new ArrayList<Borne>();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listBorne;

	}


	public Borne getBorneIdX(long id){
		//ArrayList unusual
		
		queryManager.setQueryType("FIND");
		queryManager.setTable("Borne");
		queryManager.setParam(Long.toString(id));
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

