package model;

public class Client {

	private long id,idPersonne;

	public Client() {
		
	}

	public Client(long id, long idPersonne) {
		this.id = id;
		this.idPersonne = idPersonne;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}
	
	
	
	
}
