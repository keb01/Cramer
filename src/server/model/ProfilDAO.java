package server.model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Borne;
import common.Profil;


public class ProfilDAO extends DAO<Profil>{
	
//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Profil find(long id) {
		Profil Profil = new Profil();
		
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Profil WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				Profil = new Profil(rs.getInt("id"),rs.getString("nomProfil"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Profil;
	}

	@Override
	public Profil create(Profil obj) {
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO Profil values("+obj.getNomProfil()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return obj;
	}
	
	@Override
	public void delete(Profil obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Profil WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Profil update(Profil obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Profil SET id ='"+obj.getId()+"',nomProfil='"+obj.getNomProfil()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public ArrayList<Profil> getAllProfils() {
		
		ArrayList<Profil> profils = new ArrayList<Profil>();		
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Profil ";
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				Profil profil = new Profil(rs.getLong("id"),rs.getString("nomProfil"));
				profils.add(profil);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return profils;
	}
	
	
}