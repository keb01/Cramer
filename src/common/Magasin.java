package common;



import java.util.ArrayList;

public class Magasin {
	private long id;
	private String logo;
	private String nom;
	private long idEmplacement;
	private long idCategorieMagasin;
	private String description;
	private ArrayList<Article> listeProduits;
	
	
	public Magasin(){
		
	}
	
	public Magasin(long id, String logo, String nom, String description, long idEmplacement, long idCategorieMagasin){
		this.id = id;
		this.logo = logo;
		this.nom = nom;
		this.description = description;
		this.idEmplacement = idEmplacement;
		this.idCategorieMagasin = idCategorieMagasin;
		this.listeProduits = new ArrayList<Article>();
	}
	
	
	
	
	
	public ArrayList<Article> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(ArrayList<Article> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getIdEmplacement() {
		return idEmplacement;
	}
	public void setIdEmplacement(long idEmplacement) {
		this.idEmplacement = idEmplacement;
	}
	public long getIdCategorieMagasin() {
		return idCategorieMagasin;
	}
	public void setIdCategorieMagasin(long idCategorieMagasin) {
		this.idCategorieMagasin = idCategorieMagasin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		return this.nom;
	}
}
