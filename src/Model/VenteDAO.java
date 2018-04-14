package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VenteDAO extends DAO<Vente>{
	
	private DAO<CategorieMagasin> DAOmagasin = new CategorieMagasinDAO();

//*****************************************Extended methods of DAO*********************************************************	
	
	@Override
	public Vente find(long id) {
		Vente v = new Vente();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Vente WHERE id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				v = new Vente(rs.getLong("id"),
										rs.getLong("idArticle"),
										rs.getLong("idEmploye"),
										rs.getLong("idClient"),
										rs.getLong("quantite"),
										rs.getLong("prix"),
										rs.getTimestamp("dateVente")); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public Vente create(Vente obj) {
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "INSERT longO Vente values("+obj.getIdArticle()+","+obj.getIdEmploye()+","+obj.getIdClient()+","+obj.getQuantite()+","+obj.getPrix()+","+obj.getDateVente()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return obj;
	}
	
	@Override
	public void delete(Vente obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "DELETE FROM Vente WHERE idClient ="+obj.getIdClient();
			System.out.println(sql);
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Vente update(Vente obj) {
		Statement st =null;
		
		try {
			st = this.connect.createStatement();
			String sql = "UPDATE Vente SET id = '"+obj.getId()+"',idArticle='"+obj.getIdArticle()+"',idEmploye='"+obj.getIdEmploye()+"',idClient='"+obj.getIdClient()+"',quantite='"+obj.getQuantite()+"',prix='"+obj.getPrix()+"',dateVente='"+obj.getDateVente()+"' WHERE id ="+obj.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	

	
	
	
//***********************************************************************************************************************	
	


	public CategorieMagasin findCategorieMagasin(long id) {
		CategorieMagasin catMag = new CategorieMagasin();
		
		Statement st =null;
		ResultSet rs =null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT Cm.id, Cm.nom FROM CategorieMagasin Cm JOIN Employe E JOIN Magasin M Vente V ON E.id = M.idEmploye and M.idCategorieMagasin=Cm.id and E.idMagasin=M.id WHERE V.id="+id;
			rs = st.executeQuery(sql);
			
			if(rs.first()) {
				catMag = new CategorieMagasin(rs.getLong("id"),
											  rs.getString("nom")
						 	);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return catMag;
	}
	
	public ArrayList<Vente> getAllVentes(long idClient){
		
		ArrayList<Vente> liste = new ArrayList<Vente>();
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Vente where idClient='"+idClient;
			rs = st.executeQuery(sql);
			DAOmagasin.setConnection(connect);  
			
			while(rs.next()) {
				liste.add(new Vente(rs.getLong("id"),
						rs.getLong("idArticle"),
						rs.getLong("idEmploye"),
						rs.getLong("idClient"),
						rs.getLong("quantite"),
						rs.getLong("prix"),
						rs.getTimestamp("dateVente")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
