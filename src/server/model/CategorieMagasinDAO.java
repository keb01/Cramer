package server.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategorieMagasinDAO extends DAO<CategorieMagasin>{

//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public CategorieMagasin find(long id) {
		CategorieMagasin cm = new CategorieMagasin();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM CategorieMagasin WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				cm = new CategorieMagasin(rs.getInt("id"),
										rs.getString("nom")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cm;
	}

	@Override
public CategorieMagasin create(CategorieMagasin obj) {
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO Vente values("+obj.getId()+","+obj.getNom()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return obj;
	}
	
	@Override
	public void delete(CategorieMagasin obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Vente WHERE idClient ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public CategorieMagasin update(CategorieMagasin obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Vente SET id = '"+obj.getId()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
		
	
//***********************************************************************************************************************	
	
}
