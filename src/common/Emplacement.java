package common;

public class Emplacement {
	private long id;
	private double price;
	private int area;
	private Zone zone;
	
	public Emplacement(long id, double price, int area, Zone zone) {
		super();
		this.id = id;
		this.price = price;
		this.area = area;
		this.zone = zone;
	}
	public Emplacement(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	
	
	
}
