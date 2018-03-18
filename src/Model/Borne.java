package Model;

public class Borne {
	private int id;
	private Zone zone;


	public Borne () {
	}

	public Borne(int id, Zone zone) {
	this.id = id;
	this.zone = zone;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

}
