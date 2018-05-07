package common;

public class Achat {
	public long id;
	public long idEmploye; 
	//idArticle 
	public String dateAchat; 
	public int statut;  
	public int total; 
	public long idFournisseur;
	
	public Achat(long id, long idEmploye, String dateAchat, int statut, int total, long idFournisseur) {
		this.id = id;
		this.idEmploye = idEmploye;
		this.dateAchat = dateAchat;
		this.statut = statut;
		this.total = total;
		this.idFournisseur = idFournisseur;
	}

}
