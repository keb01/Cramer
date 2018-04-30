package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ZoneDAO extends DAO<Zone> {

//*****************************************Extended methods of DAO*********************************************************	
	
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
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO Zone values("+obj.getNom()+","+obj.getDescription()+","+obj.getCoefP()+")";
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	@Override
	public Zone update(Zone obj) {
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "Update Zone set "+obj.getNom()+","+obj.getDescription()+","+obj.getCoefP()+"where id="+obj.getId();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Zone obj) {
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Zone where id="+obj.getId();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public ArrayList<Zone> getAllZones(){
		
		ArrayList<Zone> liste = new ArrayList<Zone>();
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Zone ";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				liste.add(new Zone(rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("description"),
						rs.getDouble("coefPrivilege")));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	
}
