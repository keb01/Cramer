package Model;

public class Personne {
	private long id,codePostal,age,idProfil;
	private String nom,prenom,adresse,ville;
	
	public Personne(long id,String nom, String prenom,long age, String adresse,long codePostal, String ville, long idProfil) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.adresse=adresse;
		this.codePostal=codePostal;
		this.ville=ville;
		this.idProfil=idProfil;
	}
	
	public Personne() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(long codePostal) {
		this.codePostal = codePostal;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(long idProfil) {
		this.idProfil = idProfil;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
}
