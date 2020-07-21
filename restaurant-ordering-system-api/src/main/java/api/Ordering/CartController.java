package api.Ordering;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import api.Inventory.Item;
import api.Inventory.ItemRepository;

@Controller
public class CartController {
	@Autowired
	private ItemRepository itemRepository;

	Cart userCart = new Cart();
	@RequestMapping(value = "checkout", method=RequestMethod.GET)
	public String getCartContents(Model model) {
		model.addAttribute("itemsAddedToCart",userCart.getItemsAddedToCart());
		model.addAttribute("totalPrice",userCart.getTotalPrice());
		//System.out.println("--------------> name: "+item.getName());
		return "checkout/index";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String addItemToCart(@RequestParam String itemId) {
		Item newItem = itemRepository.findById(Integer.parseInt(itemId));
		userCart.addItemToCart(newItem);
		return "redirect:/checkout";
	}

	/*
		@RequestMapping(value = "/cart", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getCartContents() {
		List<Item> inventory = itemRepository.findAll();
		return cart.getItems(inventory);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST, consumes = "application/json" )
	public ResponseEntity <String> addItemToCart(@RequestBody Item item) {
		cart.addItemToCart(item.getId());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	 */

}