package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.*;

public class RedevanceDAO extends DAO<Redevance>{
	MagasinDAO magasinDao = new MagasinDAO();
	//*****************************************Extended methods of DAO*********************************************************	
	
		@Override
		public Redevance find(long id_redevance) {
			Redevance redevance = new Redevance();
			magasinDao.setConnection(this.connect);
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "SELECT * FROM Redevance WHERE id_redevance="+id_redevance;
				rs = st.executeQuery(sql);
				
				if(rs.first()) {
					redevance = new Redevance(rs.getInt("id_redevance"),
							magasinDao.find(rs.getInt("idMagasin")),									
							rs.getString("nom_magasin"),
									rs.getFloat("montant_redevance"),
									rs.getDate("date_redevance")); 
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return redevance;
		}

		@Override
		public Redevance create(Redevance obj) {
			
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "INSERT INTO Redevance values("+obj.getid_Redevance()+","+obj.getId_magasin()+","+obj.getNom_magasin()+","+obj.getMontant_redevance()+","+obj.getDate_redevance()+")";
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return obj;
		}
		
		@Override
		public Redevance update(Redevance obj) {
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "Update Redevance set "+obj.getId_magasin()+","+obj.getNom_magasin()+","+obj.getMontant_redevance()+","+obj.getDate_redevance()+"where id_redevance="+obj.getid_Redevance();
				
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return obj;
		}

		@Override
		public void delete(Redevance obj) {
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "DELETE FROM Redevance where id_redevance="+obj.getid_Redevance();
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	public ArrayList<Redevance> getAllRedevances(){
		magasinDao.setConnection(this.connect);
			ArrayList<Redevance> liste = new ArrayList<Redevance>();
			
			
			Statement st = null;
			ResultSet rs = null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "SELECT * FROM Redevance ";
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					liste.add(new Redevance(rs.getInt("id_redevance"),
							magasinDao.find(rs.getInt("id-magasin")),
							rs.getString("nom_magasin"),
							rs.getFloat("montant_redevance"),
							rs.getDate("date_redevance"))); 
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return liste;
		}
		
		
	}
