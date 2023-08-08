
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Coffee test Class to check methods
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoffeeTestStudent {

	@Test
	public void testCalcPrice() {
		Coffee coffee1 = new Coffee("Moccha", Size.SMALL, true, true);
		Coffee coffee2 = new Coffee("Frappe", Size.MEDIUM, false, false);

		assertEquals(3, coffee1.calcPrice(), 0.001);

		assertEquals(3, coffee2.calcPrice(), 0.001);
	}

	@Test
	public void testToString() {
		Coffee coffee = new Coffee("Cappuccino", Size.LARGE, true, false);
		String expectedString = "Cappuccino,LARGE,true,false," + coffee.calcPrice();
		assertEquals(expectedString, coffee.toString());
	}

	@Test
	public void testEquals() {
		Coffee coffee1 = new Coffee("Americano", Size.MEDIUM, true, false);
		Coffee coffee2 = new Coffee("Americano", Size.MEDIUM, true, false);

		assertEquals(coffee1, coffee2);

	}

}
