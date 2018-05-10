package client.dtoClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;

import common.Fournisseur;
import common.Magasin;
import common.Personne;
import common.StockMagasin;

public class ClientStockMagasinDTO extends ClientDAO<StockMagasin> {
	private Query queryManager;
    
    public ClientStockMagasinDTO(Query q) {
		this.queryManager = q;		
	}

	@Override
	public StockMagasin find(long id) {
		return null;
	}

	@Override
	public StockMagasin create(StockMagasin obj) {
		// TODO Auto-generated method stub
		return null;
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
    
	public ArrayList<StockMagasin> getAllStocks(long magasinId) {
		
		queryManager.setQueryType("LIST");
		queryManager.setTable("STOCK");
		queryManager.setParam("{\"idMagasin\":"+magasinId+"}");
		String answer = queryManager.executeQuery();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<StockMagasin> liste = new ArrayList<>();
		
		try {
			StockMagasin[] tab = objectMapper.readValue(answer, StockMagasin[].class);
			liste = new ArrayList<>(Arrays.asList(tab));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return liste;
		
	}
  
  public void modifier(long idMagasin, long idArticle, int quantite) {
	  	queryManager.setQueryType("UPDATE");
		queryManager.setTable("STOCK");
		queryManager.setParam("{\"idMagasin\":"+idMagasin+", \"idArticle\":"+idArticle+", \"quantite\":"+quantite+"}");
		String answer = queryManager.executeQuery();
  }
}