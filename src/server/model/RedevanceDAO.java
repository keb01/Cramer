package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.*;

public class RedevanceDAO extends DAO<Redevance>{
	MagasinDAO magasinDao = new MagasinDAO();
	EmplacementDAO emplacementDao = new EmplacementDAO();
	ZoneDAO zoneDao = new ZoneDAO();
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
		
		
		
		
		
		public float calculR(long idMag) {
			int montant = 0 ;
			magasinDao.setConnection(this.connect);
			emplacementDao.setConnection(this.connect);
			zoneDao.setConnection(this.connect);
			Statement st =null;
			ResultSet rs =null;
			
			
			try {
				st = this.connect.createStatement();
				String sql = "SELECT e.area, z.coefP, f.freqmensu FROM Redevance r, Magasin m, Emplacement e, Zone z, Frequentation f where r.id_magasin=idMag and r.id_magasin=m.id and m.idEmplacement=e.id and e.Zone=z.id and m.id=f.id";
				//System.out.println(sql); 
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					int s = rs.getInt("area");
					int coefP = rs.getInt("coefP");
					int freqmensu = rs.getInt("freqmensu");
					 montant = 50 * s * coefP + freqmensu ;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("montant = 50 * s * coefP + freqmensu = " + montant);
			return  montant ;
			
		}
		
		
		
		
		public String  afficheF(long idMag) {
			int montant = 0 ;
			magasinDao.setConnection(this.connect);
			emplacementDao.setConnection(this.connect);
			zoneDao.setConnection(this.connect);
			Statement st =null;
			ResultSet rs =null;
			int s = 0;
			int coefP = 0;
			int freqmensu = 0 ;
			
			try {
				st = this.connect.createStatement();
				String sql = "SELECT e.area, z.coefP, f.freqmensu FROM Redevance r, Magasin m, Emplacement e, Zone z, Frequentation f where r.id_magasin=idMag and r.id_magasin=m.id and m.idEmplacement=e.id and e.Zone=z.id and m.id=f.id";
				//System.out.println(sql); 
				rs = st.executeQuery(sql);
				
				
				while(rs.next()) {
					 s = rs.getInt("area");
					 coefP = rs.getInt("coefP");
					 freqmensu = rs.getInt("freqmensu");
					 montant = 50 * s * coefP + freqmensu ;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String string = new String();
			string = "montant = 50 * " + s + "*" + coefP + "+" + freqmensu ;
			return string;
			
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
