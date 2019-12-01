package api.Ordering;

import static org.junit.Assert.*;

import org.junit.Test;

import api.Inventory.Item;

public class OrderTest {
	@Test
    public void testSetId() {
        //given
        final Order order = new Order();

        order.setId(1);
        assertTrue(order.getId()==1);
    }
  
  @Test
    public void testSetDetails() {
        //given
        final Order order= new Order();

        order.setDetails("one falafel");
        assertTrue(order.getDetails()=="one falafel");
    }
  

}
