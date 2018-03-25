package Model;

public class Borne {
	private long id;
	private Zone zone;


	public Borne () {
	}

	public Borne(long id, Zone zone) {
	this.id = id;
	this.zone = zone;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

}
