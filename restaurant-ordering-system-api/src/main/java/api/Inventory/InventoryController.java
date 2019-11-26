package api.Inventory;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	@RequestMapping(value = "/inventory", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getCompleteInventory() {
		//return k.findAll();
		return Arrays.asList(
		new Item("Lasagna", "Culinary dish made with stacked layers of pasta alternated with sauces and ingredients",15,true),
		new Item("Poutine", "Dish that includes french fries and cheese curds topped with a brown gravy",4.35,true),
		new Item("Falafel", "deep-fried ball, or a flat or doughnut-shaped patty, made from ground chickpeas, fava beans, or both",8,true)
);
	}
}