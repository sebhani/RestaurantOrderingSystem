package api.Inventory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ItemRepositoryTest {
	@Autowired(required=true)
	private ItemRepository itemRepository;
	

	
	@Test
	  public void findAll_shouldYieldListOfItems_forNonemptyDatabase() {
		//itemRepository.save(new Item("Lasagna","Culinary dish made with stacked layers of pasta alternated with sauces and ingredients",15,true));
	    List<Item> items = itemRepository.findAll();
	    assertThat(items).isNotNull().hasSize(1);

//	    Item result = items.get(0);
//	    assertThat(result).hasFieldOrPropertyWithValue("name", "Lasagna");
//	    assertThat(result).hasFieldOrPropertyWithValue("description", "Culinary dish made with stacked layers of pasta alternated with sauces and ingredients");

	   
	  }

}
