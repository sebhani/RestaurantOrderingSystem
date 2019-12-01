package api.Ordering;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Inventory.Item;

@RestController
public class OrderController {
	@RequestMapping(value = "/saveorder", method = RequestMethod.POST, 
            consumes = "application/json")
	public void saveOrder(@RequestBody @Valid Item i) {
		ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
}
