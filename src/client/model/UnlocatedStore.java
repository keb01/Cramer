package client.model;


/**
 * Unlocated Store Model filled with the csv File
 * Used by AppGestionEmplacement class
 * 
 */
public class UnlocatedStore {
	private String name;		//Store Name
	private int size;			//Store area
	private int type;			//Store type : restaurant,food,clothes
	private int exitOption;		//Optional parameter for locations close to exit doors
	
	public UnlocatedStore(String name, int size, int type, int exitOption) {
		this.name = name;
		this.size = size;
		this.type = type;
		this.exitOption = exitOption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
