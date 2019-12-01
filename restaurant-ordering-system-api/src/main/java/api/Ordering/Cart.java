package api.Ordering;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import api.Inventory.Item;

public class Cart {
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
	}
}
