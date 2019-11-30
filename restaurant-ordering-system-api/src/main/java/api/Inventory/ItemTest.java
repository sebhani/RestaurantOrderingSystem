package api.Inventory;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

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
	  
	    public void testSetPrice() {
	        //given
	        final Item item3 = new Item("milk","white drink",2.99,false);

	        item3.setPrice(3.99);
	        assertTrue(item3.getPrice()==3.99);
	    }


}
