package api.Ordering;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Inventory.Item;
import api.Inventory.ItemRepository;

@RestController
public class CartController {
	@Autowired
    ItemRepository itemRepository;
	
	Cart cart = new Cart();
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

}
