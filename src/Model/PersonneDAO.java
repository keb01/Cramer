package Model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Borne;


public class PersonneDAO extends DAO<Personne>{
	
//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Personne find(long id) {
		Personne personne = new Personne();
		
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Personne WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				personne = new Personne(rs.getInt("id"),
										rs.getString("nom"), 
										rs.getString("prenom"), 
										rs.getInt("age"), 
										rs.getString("adresse"), 
										rs.getInt("codePostal"), 
										rs.getString("ville"),  
										rs.getInt("idProfil"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personne;
	}

	@Override
	public Personne create(Personne obj) {
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO Personne values("+obj.getNom()+","+obj.getPrenom()+","+obj.getAge()+","+obj.getAdresse()+","+obj.getCodePostal()+","+obj.getVille()+","+obj.getIdProfil()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return obj;
	}
	
	@Override
	public void delete(Personne obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Personne WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Personne update(Personne obj) {
		//System.out.println(obj.getId()+"   :   to zone "+obj.getZone().getId());
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Personne SET id='"+obj.getId()+"',nom='"+obj.getNom()+"',prenom='"+obj.getPrenom()+"',age='"+obj.getAge()+"',adresse='"+obj.getAdresse()+"',codepostal='"+obj.getCodePostal()+"',ville='"+obj.getVille()+"',idProfil='"+obj.getIdProfil()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	
	public Personne updateIdProfil(Personne obj) {

		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Personne SET idProfil = '"+obj.getIdProfil()+"' WHERE id ="+obj.getId();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public ArrayList<Personne> getAllClients(){
		
		ArrayList<Personne> personnes =new  ArrayList<Personne>();
		Statement st =null;
		ResultSet rs =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * from Personne where id in (select idPersonne from Client)";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Personne personne = new Personne(rs.getInt("id"),
										rs.getString("nom"), 
										rs.getString("prenom"), 
										rs.getInt("age"), 
										rs.getString("adresse"), 
										rs.getInt("codePostal"), 
										rs.getString("ville"),  
										rs.getInt("idProfil"));
				personnes.add(personne);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personnes;
		
	}
	
}