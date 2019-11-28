package api.Inventory;

import java.util.List;

import javax.validation.constraints.DecimalMin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

@RestController
public class InventoryController {
	
	@Autowired
    ItemRepository itemRespository;
	@RequestMapping(value = "/inventory", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getCompleteInventory() {
		return itemRespository.findAll();
	}
	
	@RequestMapping(value = "/inventory/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Item getItem(@PathVariable @NotNull @DecimalMin("1") int id) {
		return itemRespository.findOne(id);
	}
}