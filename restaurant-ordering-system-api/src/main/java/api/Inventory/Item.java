package api.Inventory;

import javax.persistence.*;

@Entity
//@Table(name = "item")
public class Item {
	private static int _id = 1;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id")
	private int id;
	//@Column(name = "name")
	private String name;
	//@Column(name = "description")
	private String description;
	//@Column(name = "price")
	private int price;
	private boolean isAvailable;
	
	public Item(String name, String description, int price, boolean isAvailable) {
		this.id = _id;
		_id++;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		
	}
	
	public Item(int id, String name, String description, int price, boolean isAvailable) {
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
	public int getPrice() {
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
