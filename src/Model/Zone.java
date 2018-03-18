package Model;

public class Zone {
	
	private long id;
	private String nom;
	private String description;
	private double coefPrivilege;

	public Zone() {
		
	}
	
	public Zone(long id, String nom, String description, double coefPrivilege){
		this.id=id;
		this.nom=nom;
		this.description=description;
		this.coefPrivilege=coefPrivilege;
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
	
	public double getCoefPrvilege(){
		return coefPrivilege;
	}
	
	public void setCoefPrivilege(double coefPrivilege){
		this.coefPrivilege=coefPrivilege;
	}
}
