package api.Ordering;

import java.util.ArrayList;
import api.Inventory.Item;

public class Cart {

	private ArrayList<Item> itemsAddedToCart;
	private double totalPrice;
	private int quantity;
	private static int couponDiscount;


	//Constructors
	public Cart(){
		itemsAddedToCart = new ArrayList<Item>();
		totalPrice = 0;
	}

	public void addItemToCart(Item newItem){
		if(!itemsAddedToCart.isEmpty()){//this will allow a single item to be stored in the arraylist
			itemsAddedToCart.remove(0);
		}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static int getCouponDiscount() {
		return couponDiscount;
	}

	public static void setCouponDiscount(int couponDiscount) {
		Cart.couponDiscount = couponDiscount;
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