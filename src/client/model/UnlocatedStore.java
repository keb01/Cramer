package client.model;


/**
 * Unlocated Store Model filled with the csv File
 * Used by AppGestionEmplacement class
 * 
 */
public class UnlocatedStore {
	private String name;		//Store Name
	private int area;			//Store area
	private int type;			//Store type : restaurant,food,clothes
	private int exitOption;		//Optional parameter for locations close to exit doors
	
	public UnlocatedStore(String name, int area, int type, int exitOption) {
		this.name = name;
		this.area = area;
		this.type = type;
		this.exitOption = exitOption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getExitOption() {
		return exitOption;
	}

	public void setExitOption(int exitOption) {
		this.exitOption = exitOption;
	}

	
	
}
