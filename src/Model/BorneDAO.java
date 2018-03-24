package Model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BorneDAO extends DAO<Borne>{
	
private DAO<Zone> DAOzone = new ZoneDAO();

//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Borne find(long id) {
		Borne borne = new Borne();
		
	
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Borne WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				borne = new Borne(rs.getInt("id"),
								  DAOzone.find(rs.getInt("idZone")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return borne;
	}

	@Override
	public Borne create(Borne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borne update(Borne obj) {

		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Borne SET Zone = '"+obj.getZone()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			obj = this.find(obj.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Borne obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Borne WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//***********************************************************************************************************************	
	
	public Borne findZone(long id, long idZone) {
		Borne borne = new Borne();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT idZone FROM Borne B JOIN Zone Z ON B.idZone = Z.idZone WHERE B.id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				borne = new Borne(rs.getInt("B.id"),
						 		  DAOzone.find(rs.getInt("idZone")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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

}

