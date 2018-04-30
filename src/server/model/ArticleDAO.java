package server.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Article;


public class ArticleDAO extends DAO<Article>{
	
private DAO<CategorieArticle> DAOca = new CategorieArticleDAO();	

//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Article find(long id) {
		Article produit = new Article();
		
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Article WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				produit = new Article(rs.getInt("id"),
										rs.getString("nom"), 
										rs.getString("description"), 
										rs.getString("image"), 
										rs.getInt("poids"), 
										rs.getString("provenance"), 
										DAOca.find(rs.getInt("idcategorie")),  
										0.0); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produit;
	}

	@Override
	public Article create(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article update(Article obj) {

		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Article SET nom = '"+obj.getNom()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			obj = this.find(obj.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Article obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Article WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//***********************************************************************************************************************	
	
	public Article findInMagasin(long idMag, long idProd) {
		Article produit = new Article();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Article A JOIN StockMagasin SM ON A.id = SM.idArticle WHERE A.id="+idProd+" AND SM.idMagasin="+idMag;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				produit = new Article(rs.getInt("A.id"),
										rs.getString("A.nom"), 
										rs.getString("A.description"), 
										rs.getString("A.image"), 
										rs.getInt("A.poids"), 
										rs.getString("A.provenance"), 
										DAOca.find(rs.getInt("idcategorie")),
										rs.getDouble("SM.prixUnitaire")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produit;
	}
	
	public void deleteInMagasin(Article obj, long idMag) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM StockMagasin WHERE idArticle ="+obj.getId()+" AND idMagasin ="+idMag;
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
