package Model;

public class Profil {
	
	private long id;
	private String nomProfil;
	
	public Profil(long id, String nomProfil) {
		this.id = id;
		this.nomProfil = nomProfil;
	}
	
	public Profil() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomProfil() {
		return nomProfil;
	}
	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}
	
	
	
	
}
