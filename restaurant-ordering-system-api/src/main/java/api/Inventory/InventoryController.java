package api.Inventory;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	@RequestMapping("/inventory")
	public List<Item> getCompleteInventory() {
		return Arrays.asList(
					new Item("Vegetarian Burger", "Burger containing no meat products", 7.99, true),
					new Item("Chicken Burger", "Ingredients include chicken", 8.99, true),
					new Item("Cheese Pizza", "Cheese pizza, mozerella cheese", 4.25, true)
					);
	}
}
