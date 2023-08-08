
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: BevShop test class to check methods
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

	private BevShop bevShop;

	@Before
	public void setUp() {
		bevShop = new BevShop();
	}

	@Test
	public void testIsValidTime() {
		assertTrue(bevShop.isValidTime(BevShop.MIN_TIME));
		assertTrue(bevShop.isValidTime(BevShop.MAX_TIME));
		assertFalse(bevShop.isValidTime(BevShop.MIN_TIME - 1));
		assertFalse(bevShop.isValidTime(BevShop.MAX_TIME + 1));
	}

	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(BevShop.MAX_FRUIT, bevShop.getMaxNumOfFruits());
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(BevShop.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
	}

	@Test
	public void testIsMaxFruit() {
		assertTrue(bevShop.isMaxFruit(BevShop.MAX_FRUIT + 1));
		assertFalse(bevShop.isMaxFruit(BevShop.MAX_FRUIT));
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(BevShop.MAX_ORDER_FOR_ALCOHOL, bevShop.getMaxOrderForAlcohol());
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
		assertEquals(1, bevShop.getNumOfAlcoholDrink());

	}

	@Test
	public void testIsValidAge() {
		assertTrue(bevShop.isValidAge(BevShop.MIN_AGE_FOR_ALCOHOL));
		assertFalse(bevShop.isValidAge(BevShop.MIN_AGE_FOR_ALCOHOL - 1));
	}

	@Test
	public void testStartNewOrder() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		Order order = bevShop.getCurrentOrder();
		assertNotNull(order);
		assertEquals("John", order.getCustomer().getName());
	}

	@Test
	public void testProcessCoffeeOrder() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processCoffeeOrder("Frappe", Size.SMALL, true, false);
		Order order = bevShop.getCurrentOrder();
		assertNotNull(order);
		assertEquals(1, order.getTotalItems());
		assertEquals(2.5, order.calcOrderTotal(), 0.001);
	}

	@Test
	public void testProcessAlcoholOrder() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processAlcoholOrder("Champagne", Size.SMALL);
		Order order = bevShop.getCurrentOrder();
		assertNotNull(order);
		assertEquals(1, order.getTotalItems());
		assertEquals(2.0, order.calcOrderTotal(), 0.001);
	}

	@Test
	public void testProcessSmoothieOrder() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processSmoothieOrder("Fruit Smoothie", Size.LARGE, 3, true);
		Order order = bevShop.getCurrentOrder();
		assertNotNull(order);
		assertEquals(1, order.getTotalItems());
		assertEquals(7.0, order.calcOrderTotal(), 0.001);
	}

	@Test
	public void testFindOrder() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		int orderNo = bevShop.getCurrentOrder().getOrderNo();
		int foundIndex = bevShop.findOrder(orderNo);
		assertTrue(foundIndex >= 0);
		assertEquals(orderNo, bevShop.getOrderAtIndex(foundIndex).getOrderNo());
	}

	@Test
	public void testTotalOrderPrice() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
		double totalOrderPrice = bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo());
		assertEquals(2.5, totalOrderPrice, 0.001);
	}

	@Test
	public void testTotalMonthlySale() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
		bevShop.startNewOrder(14, Day.MONDAY, "Jane", 30);
		bevShop.processAlcoholOrder("Wine", Size.SMALL);
		double totalMonthlySale = bevShop.totalMonthlySale();
		assertEquals(4.5, totalMonthlySale, 0.001);
	}

	@Test
	public void testTotalNumOfMonthlyOrders() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.startNewOrder(14, Day.MONDAY, "Jane", 30);
		assertEquals(2, bevShop.totalNumOfMonthlyOrders());
	}

	@Test
	public void testSortOrders() {
		bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
		bevShop.sortOrders();
		assertEquals("John", bevShop.getOrderAtIndex(0).getCustomer().getName());

	}

}
