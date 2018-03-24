package DAOClient;

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
}
