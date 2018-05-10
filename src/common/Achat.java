package common;

public class Achat {
  public static final int STATUT_COMMANDE = 0;
  public static final int STATUT_RECU = 1;
  public static final int STATUT_ANNULE = 2;
  
  public static String statutText(int statut) {
	  switch(statut) {
	    case STATUT_ANNULE: return "Annulé";
	    case STATUT_COMMANDE: return "Commandé";
	    case STATUT_RECU: return "Reçu";
	    default: return "Invalide";
	  }
  }
  
	public long id;
	public long idEmploye; 
	//idArticle 
	public String dateAchat; 
	public int statut;  
	public int total; 
	public long idFournisseur;
	
  public Achat() {
    
  }
  
  public String toString() {
    return "(statut: "+statutText(statut)+") le "+dateAchat;
  }
  
	public Achat(long id, long idEmploye, String dateAchat, int statut, int total, long idFournisseur) {
		this.id = id;
		this.idEmploye = idEmploye;
		this.dateAchat = dateAchat;
		this.statut = statut;
		this.total = total;
		this.idFournisseur = idFournisseur;
	}

}
