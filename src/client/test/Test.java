package client.test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws SQLException {
		delete();
		select();
		insert();
		select();
		/*update();
		select();
		delete();	
		select();*/
	}

	public static void insert() throws SQLException {
		
		Connection cn =null;
		
		try {			
			Statement st =null;
			cn = Database.getConnection();
			st = cn.createStatement();

			String sql = "INSERT INTO Client (nom,prenom,adresse,email,tel,sexe,caracteristiques) VALUES ('Bismuth','Keren','','kerenbismuth@gmail.com','0601340606','Femme','')";

			st.executeUpdate(sql);

			} catch (SQLException e) {
					e.printStackTrace();
			} finally {
			cn.close();	
			}
		}
	
	public static void update() throws SQLException {
		
		Connection cn =null;
		
		try {			
			Statement st =null;
			cn = Database.getConnection();
			st = cn.createStatement();

			String sql = "Update Client set nom = 'femme' where id_client = 1";

			st.executeUpdate(sql);

			} catch (SQLException e) {
					e.printStackTrace();
			} finally {
			cn.close();	
			}
		}
	
	public static void delete() throws SQLException {
		Connection cn =null;
		
		try {			
			Statement st =null;
			cn = Database.getConnection();
			st = cn.createStatement();

			String sql = "Delete from Client where prenom = 'Keren'";

			st.executeUpdate(sql);

			} catch (SQLException e) {
					e.printStackTrace();
			} finally {
			cn.close();	
			}
		}
	public static void select() throws SQLException {
		Connection cn =null;
		
		
		try {
			
			Statement st =null;
			ResultSet rs =null;
			cn = Database.getConnection();
			
			st = cn.createStatement();
			String sql = "SELECT * FROM Client";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("id_client")+"|"+rs.getString("Nom")+"|"+rs.getString("Prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}finally{
			
			cn.close();
			
		}
	}
	
}

