package server.model;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.Achat;
import common.AchatDetail;
import common.Magasin;
import common.StockMagasin;

public class AchatDAO extends DAO<Achat> {
	
	private MagasinDAO magasinDAO = new MagasinDAO();
	private StockMagasinDAO stockMagasinDAO = new StockMagasinDAO();

	@Override
	public Achat find(long id) {

		Achat achat = null;

		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Achat WHERE id=" + id;
			rs = st.executeQuery(sql);

			if (rs.first()) {
				achat = new Achat(rs.getInt("Id"), rs.getInt("IdEmploye"), rs.getString("DateAchat"),
						rs.getInt("Statut"), rs.getInt("Total"), rs.getInt("IdFournisseur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return achat;

	}

	@Override
	public Achat create(Achat obj) {
		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();

			String sql = "INSERT INTO Achat values(NULL," + obj.idEmploye + ",NULL," + "" + obj.dateAchat + ","
					+ obj.statut + "," + obj.total + "," + obj.idFournisseur + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public Achat update(Achat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Achat obj) {
		// TODO Auto-generated method stub

	}

	public ArrayList<AchatDetail> getAllAchatDetails(long id) {

		ArrayList<AchatDetail> liste = new ArrayList<>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM AchatDetails where IdAchat=" + id;
			rs = st.executeQuery(sql);

			while (rs.next()) {
				liste.add(new AchatDetail(rs.getInt("IdAchat"), rs.getInt("IdArticle"), rs.getInt("Quantite")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public void addDetailsAchat(List<AchatDetail> list, long idAchat) {
		try {
			Statement st = this.connect.createStatement();
			for (AchatDetail d : list)
				st.executeUpdate("INSERT INTO AchatDetails (`IdAchat`, `IdArticle`, `Quantite`) " + "VALUES (" + idAchat
						+ "," + d.idArticle + "," + d.quantite + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Achat> getAllAchats() {

		ArrayList<Achat> liste = new ArrayList<>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM Achat";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				liste.add(new Achat(rs.getInt("Id"), rs.getInt("IdEmploye"), rs.getString("DateAchat"),
						rs.getInt("Statut"), rs.getInt("Total"), rs.getInt("IdFournisseur")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public void updateStatut(Achat a) {
		try {

			Statement st = this.connect.createStatement();
			stockMagasinDAO.setConnection(connect);

			if (a.statut == Achat.STATUT_RECU) {
				ArrayList<AchatDetail> details = getAllAchatDetails(a.id);
				magasinDAO.setConnection(connect);
				Magasin magasin = magasinDAO.getMagasinDAchat(a.id);
				ArrayList<StockMagasin> stocks = stockMagasinDAO.getAllStocksMagasin(magasin.getId());

				HashMap<Long, StockMagasin> stocksByArticleId = new HashMap<>();
				for (StockMagasin s : stocks)
					stocksByArticleId.put(s.idArticle, s);

				for (AchatDetail detail : details) {
					StockMagasin stock = stocksByArticleId.get(detail.idArticle);
					if (stock == null) {
						stock = new StockMagasin();
						stock.idMagasin = magasin.getId();
						stock.prixUnitaire = 10000;
						stock.quantite = detail.quantite;
						stock.idArticle = detail.idArticle;
						stockMagasinDAO.create(stock);
						stocksByArticleId.put(stock.idArticle, stock);
					} else {
						stock.quantite += detail.quantite;
						stockMagasinDAO.updateStockQuantiteFromID(stock);
					}
				}
			}

			String sql = "UPDATE Achat SET statut='" + a.statut + "' WHERE id=" + a.id;
			st.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
