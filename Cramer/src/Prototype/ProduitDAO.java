package Prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProduitDAO extends DAO<Produit>{

	@Override
	public Produit find(long id) {
		Produit produit = new Produit();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Article WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				produit = new Produit(rs.getInt("id"),
										rs.getString("nom"), 
										rs.getString("description"), 
										rs.getString("image"), 
										rs.getInt("poids"), 
										rs.getString("provenance"), 
										rs.getInt("idcategorie")); //DAO Categorie à faire
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produit;
	}

	@Override
	public Produit create(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Produit obj) {
		// TODO Auto-generated method stub
		
	}

}
