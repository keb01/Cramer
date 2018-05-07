package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Fournisseur;
import common.Magasin;

public class FournisseurDAO extends DAO<Fournisseur> {

	@Override
	public Fournisseur find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur create(Fournisseur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur update(Fournisseur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Fournisseur obj) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Fournisseur> getAllFournisseurs(){
		
		ArrayList<Fournisseur> liste = new ArrayList<>();
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Fournisseur";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				liste.add(new Fournisseur(rs.getInt("id"),
						rs.getString("Siret"), 
						rs.getInt("IdCategorieArticle")
						));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
}
