package server.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import common.Emplacement;

public class EmplacementDAO extends DAO<Emplacement> {
	ZoneDAO zoneDao = new ZoneDAO();

//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Emplacement find(long id) {
		Emplacement emp = new Emplacement();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Emplacement WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				emp = new Emplacement(rs.getLong("id"),
								rs.getDouble("loyer"),
								rs.getInt("superficie"),
								zoneDao.find(rs.getInt("idZone"))); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Emplacement create(Emplacement obj) {
		Statement st =null;
		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO Emplacement values("+obj.getPrice()+","+obj.getArea()+","+obj.getZone().getId()+")";
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	@Override
	public Emplacement update(Emplacement obj) {
		Statement st =null;
		try {
			st = this.connect.createStatement();
			String sql = "Update Emplacement set "+obj.getPrice()+","+obj.getArea()+","+obj.getZone().getId()+" where id="+obj.getId();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Emplacement obj) {
		Statement st =null;
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Emplacement where id="+obj.getId();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public ArrayList<Emplacement> getAllEmplacement(){
		
		ArrayList<Emplacement> liste = new ArrayList<Emplacement>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Emplacement ";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				liste.add(new Emplacement(rs.getLong("id"),
						rs.getDouble("loyer"),
						rs.getInt("superficie"),
						zoneDao.find(rs.getInt("idZone"))));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	
}
