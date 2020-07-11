package api.Ordering;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import api.Inventory.Item;
import api.Inventory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Cart {

	private ArrayList<Item> itemsAddedToCart;
	private double totalPrice;

	//Constructors
	public Cart(){
		itemsAddedToCart = new ArrayList<Item>();
		totalPrice = 0;
	}

	public void addItemToCart(Item newItem){
		itemsAddedToCart.add(newItem);
		totalPrice+=newItem.getPrice();
	}

	//Setters and Getters
	public ArrayList<Item> getItemsAddedToCart() {
		return itemsAddedToCart;
	}

	public void setItemsAddedToCart(ArrayList<Item> itemsAddedToCart) {
		this.itemsAddedToCart = itemsAddedToCart;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/*
	private Set<Integer> itemIds = new HashSet<Integer>();
	private double totalPrice;

	
    public Cart() {}
	public double calculateTotalPrice(List<Double> prices) {
		for (double price : prices) {
			totalPrice +=price;
		}
		return totalPrice;
		
	}
	
	public void addItemToCart(int id) {
		itemIds.add(id);
	}

	public List<Item> getItems(List<Item> inventory){
		List <Item> items = new ArrayList<Item>();
		
		for (int i = 0; i<inventory.size(); i++) {
			if(itemIds.contains(inventory.get(i).getId())) {
				items.add(inventory.get(i));
			}
		}
		return items;
	}*/
}
