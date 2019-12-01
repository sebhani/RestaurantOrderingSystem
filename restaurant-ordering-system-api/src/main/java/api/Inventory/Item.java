package api.Inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	private static int _id = 1;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private double price;
	private boolean isAvailable;
	
	public Item() {
	}
	
	public Item(String name, String description, int price, boolean isAvailable) {
		this.id = _id;
		_id++;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		
	}
	
	public Item(int id, String name, String description, double price, boolean isAvailable) {
		this.id = id;
		_id=id+1;
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
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int i) {
		this.id = i;
	}
	
	
	

}
