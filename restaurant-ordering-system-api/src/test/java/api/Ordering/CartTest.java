package api.Ordering;

import static org.junit.Assert.*;

import org.junit.Test;

import api.Inventory.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;




public class CartTest {

	@Test
	public void testCalculateTotalPrice() {
		final Cart cart=new Cart();
		List<Double> prices=new ArrayList<Double>();
		prices.add(2.5);
		prices.add(3.0);
		prices.add(1.4);
		double expected=6.9;
		assertTrue(expected==cart.calculateTotalPrice(prices));
	}
	
	@Test
	public void testAddItemToCart() {
		final Cart cart=new Cart();
		cart.addItemToCart(100);
		assertTrue(cart.itemIds.contains(100));		
	}
	
	@Test
	public void testGetItems() {
		final Cart cart=new Cart();
		Item item1=new Item(1,"Lasagna","Culinary dish made with stacked layers of pasta alternated with sauces and ingredients",15,true);
		Item item2=new Item(2,"Poutine","Dish that includes french fries and cheese curds topped with a brown gravy",4.35,true);
		cart.addItemToCart(1);
		cart.addItemToCart(2);
		List<Item> inventory=new ArrayList<Item>();
		List<Item> items=new ArrayList<Item>();
		items.add(item1);
		items.add(item2);		
		inventory.add(item1);
		inventory.add(item2);
		assertThat(cart.getItems(inventory), is(items));	
	}

	

}
