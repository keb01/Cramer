package common;

public class AchatDetail {
	public long idAchat; 
	public long idArticle; 
	public int quantite;
	
  public AchatDetail() {
    
  }
  
	public AchatDetail(long idAchat, long idArticle, int quantite) {
		this.idAchat = idAchat;
		this.idArticle = idArticle;
		this.quantite = quantite;
	} 
}
