package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BorneDAO extends DAO<Magasin>{ 
	private DAO<CategorieArticle> DAOca = new CategorieArticleDAO();
	
//*****************************************Methodes heritage DAO*********************************************************	
	
		@Override
		public Borne find(int id) {
			
			Borne borne = new Borne();
			
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "SELECT * FROM Borne WHERE id="+id;
				rs = st.executeQuery(sql);
				
				if(rs.first()) {
					borne = new Borne(rs.getInt("id"),
									  rs.getInt("idZone")); 
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return borne;

}
		
		@Override
		public Borne create(Borne obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Borne update(Borne obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Borne obj) {
			// TODO Auto-generated method stub
			
		}
		
	//***********************************************************************************************************************	
		
}
