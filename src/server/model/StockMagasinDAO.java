package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Article;
import common.Borne;
import common.StockMagasin;
import java.util.ArrayList;

public class StockMagasinDAO extends DAO<StockMagasin> {
	// *****************************************Extended methods of DAO*********************************************************

	@Override
	public StockMagasin find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockMagasin create(StockMagasin obj) {
		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();
			String sql = "INSERT INTO StockMagasin values(NULL," + obj.idMagasin + "," + obj.idArticle + ","
					+ obj.prixUnitaire + "," + obj.quantite + ")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public StockMagasin update(StockMagasin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(StockMagasin obj) {
		// TODO Auto-generated method stub
	}

	// ***********************************************************************************************************************

	public void updateStockQuantiteFromID(StockMagasin s) {
		Statement st = null;

		try {
			st = this.connect.createStatement();
			String sql = "UPDATE StockMagasin SET quantite = '" + s.quantite + "' WHERE id =" + s.id;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStockQuantiteFromMagasinEtArticle(StockMagasin s) {
		Statement st = null;

		try {
			st = this.connect.createStatement();

			String sql = "UPDATE StockMagasin SET quantite = '" + s.quantite + "' WHERE idMagasin=" + s.idMagasin
					+ " AND idArticle=" + s.idArticle;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<StockMagasin> getAllStocksMagasin(long idMagasin) {
		ArrayList<StockMagasin> liste = new ArrayList<>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.connect.createStatement();
			String sql = "SELECT * FROM StockMagasin WHERE idMagasin=" + idMagasin;
			rs = st.executeQuery(sql);

			while (rs.next()) {
				liste.add(new StockMagasin(rs.getInt("id"), rs.getInt("idMagasin"), rs.getInt("idArticle"),
						rs.getDouble("prixUnitaire"), rs.getInt("quantite")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}
}
