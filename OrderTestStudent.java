
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Order Test class to check methods
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

	private Customer customer;
	private Order order;

	@Before
	public void setUp() {

		customer = new Customer("Tom Holland", 40);

		order = new Order(10, Day.MONDAY, customer);
	}

	@Test
	public void testGetOrderNo() {

		int orderNo = order.getOrderNo();
		assertTrue(orderNo >= 10000 && orderNo <= 90000);
	}

	@Test
	public void testGetOrderTime() {

		assertEquals(10, order.getOrderTime());
	}

	@Test
	public void testGetOrderDay() {

		assertEquals(Day.MONDAY, order.getOrderDay());
	}

	@Test
	public void testGetCustomer() {

		assertEquals(customer, order.getCustomer());
	}

	@Test
	public void testIsWeekend() {

		assertFalse(order.isWeekend());
		Order weekendOrder = new Order(12, Day.SATURDAY, customer);
		assertTrue(weekendOrder.isWeekend());
	}

	@Test
	public void testAddNewBeverage() {

		order.addNewBeverage("Moccha", Size.SMALL, true, false);
		order.addNewBeverage("Mohito", Size.MEDIUM);
		assertEquals(2, order.getTotalItems());
		assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
	}

	@Test
	public void testCalcOrderTotal() {

		order.addNewBeverage("Moccha", Size.SMALL, true, false);
		order.addNewBeverage("Mohito", Size.MEDIUM);
		double expectedTotal = 0.0;
		for (Beverage beverage : order.getBeverages()) {
			expectedTotal += beverage.calcPrice();
		}
		assertEquals(expectedTotal, order.calcOrderTotal(), 0.001);
	}
}
