package api.Inventory;

public class Item {
	private String name;
	private String description;
	private double price;
	private boolean isAvailable;
	
	public Item(String name, String description, double price, boolean isAvailable) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
