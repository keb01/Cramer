package Prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MagasinDAO extends DAO<Magasin>{

//*****************************************Methodes heritage DAO*********************************************************	
	
	@Override
	public Magasin find(long id) {
		
		Magasin magasin = new Magasin();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Magasin WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				magasin = new Magasin(rs.getInt("id"),
										rs.getString("logo"), 
										rs.getString("nom"), 
										rs.getString("description"), 
										rs.getInt("idEmplacement"), 
										rs.getInt("idCategorieMagasin")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return magasin;
		
		
		
	}

	@Override
	public Magasin create(Magasin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Magasin update(Magasin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Magasin obj) {
		// TODO Auto-generated method stub
		
	}
	
//***********************************************************************************************************************	
	

}
