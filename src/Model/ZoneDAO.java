package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZoneDAO extends DAO<Zone> {

//*****************************************Methodes heritage DAO*********************************************************	
	
	@Override
	public Zone find(long id) {
		Zone zone = new Zone();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Zone WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				zone = new Zone(rs.getInt("id"),
								rs.getString("nom"),
								rs.getString("description"),
								rs.getDouble("coefPrivilege")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zone;
	}

	@Override
	public Zone create(Zone obj) {
		return null;
	}

	@Override
	public Zone update(Zone obj) {
		return null;
	}

	@Override
	public void delete(Zone obj) {
		
	}	
	
}
