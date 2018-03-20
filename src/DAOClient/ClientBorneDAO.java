package DAOClient;

import Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientBorneDAO extends ClientDAO {
    private ClientDAO<Zone> ClientDAOzone = new ClientZoneDAO();




    @Override
    public Object find(long id) {
        return null;
        
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public void delete(Object obj) {

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
