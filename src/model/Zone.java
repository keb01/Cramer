package model;

public class Zone {
	
	private long id;
	private String nom;
	private String description;
	private double coefP;

	public Zone() {
		
	}
	
	public Zone(long id, String nom, String description, double coefP){
		this.id=id;
		this.nom=nom;
		this.description=description;
		this.coefP=coefP;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public double getCoefP(){
		return coefP;
	}
	
	public void setCoefP(double coefP){
		this.coefP=coefP;
	}
}
