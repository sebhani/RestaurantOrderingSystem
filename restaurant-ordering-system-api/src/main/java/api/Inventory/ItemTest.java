package api.Inventory;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;




public class ItemTest {
	@Autowired(required= true )
	private JdbcOperations jdbc;
	 

	@Test
	    public void testSetName() {
	        //given
	        final Item item1 = new Item("milk","white drink",2.99,false);

	        item1.setName("chocolateMilk");
	        assertTrue(item1.getName()=="chocolateMilk");
	    }
	  
	  @Test
	    public void testSetDescription() {
	        //given
	        final Item item2 = new Item("milk","white drink",2.99,false);

	        item2.setDescription("diary drink");
	        assertTrue(item2.getDescription()=="diary drink");
	    }
	  
	  @Test
	    public void testSetPrice() {
	        //given
	        final Item item3 = new Item("milk","white drink",2.99,false);

	        item3.setPrice(3.99);
	        assertTrue(item3.getPrice()==3.99);
	    }
	  @Test
	    public void testSetAvailable() {
	        //given
	        final Item item3 = new Item("milk","white drink",2.99,false);

	        item3.setAvailable(true);
	        assertTrue(item3.isAvailable()==true);
	    }
	  
	  
	  
	  @Test
	    public void testFindOne() {
	        //given
	        //final ItemRepository iR=new ItemRepository(); 
	        final Item item = new Item("Lasagna","Culinary dish made with stacked layers of pasta alternated with sauces and ingredients",15,true);
	        final ItemRepository iR = new ItemRepository();
	        String actual=iR.findOne(1).getName();
	        String expected=item.getName();
	        assertEquals(expected, actual);
	    }
	  



}
