package Model;

public class Borne {
private int id;
private int idZone;


public Borne () {
}

public Article (int id, int idZone) {
	this.id = id;
	this.idZone = idZone;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getIdZone() {
	return idZone;
}
public void setIdZone(int idZone) {
	this.idZone = idZone;
}

}
