package Prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MagasinDAO extends DAO<Magasin>{
	private DAO<CategorieArticle> DAOca = new CategorieArticleDAO();	
	
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
	public void getListeProduit(Magasin obj){
		
		ArrayList<Produit> liste = new ArrayList<Produit>();
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Article A JOIN StockMagasin SM ON A.id = SM.idArticle WHERE SM.idMagasin="+obj.getId();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				liste.add(new Produit(rs.getInt("A.id"),
										rs.getString("A.nom"), 
										rs.getString("A.description"), 
										rs.getString("A.image"), 
										rs.getInt("A.poids"), 
										rs.getString("A.provenance"), 
										DAOca.find(rs.getInt("idcategorie")),
										rs.getDouble("SM.prixUnitaire"))); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		obj.setListeProduits(liste);
	}
	
	public ArrayList<Magasin> getAllMagasins(){
		
		ArrayList<Magasin> liste = new ArrayList<Magasin>();
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Magasin ";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				liste.add(new Magasin(rs.getInt("id"),
						rs.getString("logo"), 
						rs.getString("nom"), 
						rs.getString("description"), 
						rs.getInt("idEmplacement"), 
						rs.getInt("idCategorieMagasin")));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
}