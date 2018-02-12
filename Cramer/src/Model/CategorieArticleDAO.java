package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategorieArticleDAO extends DAO<CategorieArticle>{

//*****************************************Methodes heritage DAO*********************************************************	
	
	@Override
	public CategorieArticle find(long id) {
		CategorieArticle ca = new CategorieArticle();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM CategorieArticle WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				ca = new CategorieArticle(rs.getInt("id"),
										rs.getString("nom")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ca;
	}

	@Override
	public CategorieArticle create(CategorieArticle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategorieArticle update(CategorieArticle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CategorieArticle obj) {
		// TODO Auto-generated method stub
		
	}

	
	
	
//***********************************************************************************************************************	
	
}
