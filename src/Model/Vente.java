package Model;
import java.sql.Timestamp;

public class Vente {
	private long id;
	private long idArticle;
	private long idEmploye;
	private long idClient;
	private long quantite;
	private double prix;
	private Timestamp dateVente;

	public Vente(){
		
	}
	
	public Vente(long id, long idArticle, long idEmploye, long idClient, long quantite, double prix, Timestamp dateVente) {
		super();
		this.id = id;
		this.idArticle = idArticle;
		this.idEmploye = idEmploye;
		this.idClient = idClient;
		this.quantite = quantite;
		this.prix = prix;
		this.dateVente = dateVente;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}


	public long getIdEmploye() {
		return idEmploye;
	}


	public void setIdEmploye(long idEmploye) {
		this.idEmploye = idEmploye;
	}


	public long getIdClient() {
		return idClient;
	}


	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}


	public long getQuantite() {
		return quantite;
	}


	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Timestamp getDateVente() {
		return dateVente;
	}


	public void setDateVente(Timestamp dateVente) {
		this.dateVente = dateVente;
	}


}