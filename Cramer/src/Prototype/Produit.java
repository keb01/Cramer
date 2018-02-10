package Prototype;

public class Produit {
	private long id;
	private String nom;
	private String description;
	private String urlImage;
	private long poids;
	private String provenance;
	private CategorieArticle categorie;
	private double prix;
	

	public Produit(){
		
	}
	public Produit(long id, String nom, String description, String urlImage, long poids, String provenance, CategorieArticle categorie, double prix){
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.urlImage = urlImage;
		this.poids = poids;
		this.provenance = provenance;
		this.categorie = categorie;
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public long getPoids() {
		return poids;
	}
	public void setPoids(long poids) {
		this.poids = poids;
	}
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	public CategorieArticle getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieArticle categorie) {
		this.categorie = categorie;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}

