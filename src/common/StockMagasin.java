package common;

public class StockMagasin {
	
	public long id;
	public long idMagasin;
	public long idArticle;
	public double prixUnitaire;
	public int quantite;

  public StockMagasin(long id, long idMagasin, long idArticle, double prixUnitaire, int quantite){
    this.id = id;
    this.idMagasin = idMagasin;
    this.idArticle = idArticle;
    this.prixUnitaire = prixUnitaire;
    this.quantite = quantite;
  }
	
	
	public StockMagasin(){
		
	}
	
	
}

