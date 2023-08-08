import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Alcohol Test Class to check Alcohol class methods
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/
public class AlcoholTestStudent {

	@Test
	public void testCalcPrice() {
		Alcohol alcohol1 = new Alcohol("Wine", Size.MEDIUM, true);
		Alcohol alcohol2 = new Alcohol("Beer", Size.LARGE, false);

		assertEquals(3.6, alcohol1.calcPrice(), 0.001);

		assertEquals(4, alcohol2.calcPrice(), 0.001);
	}

	@Test
	public void testToString() {
		Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, false);
		String expectedString = "Vodka,SMALL,false," + alcohol.calcPrice();
		assertEquals(expectedString, alcohol.toString());
	}

	@Test
	public void testEquals() {
		Alcohol alcohol1 = new Alcohol("Whiskey", Size.LARGE, false);
		Alcohol alcohol2 = new Alcohol("Whiskey", Size.LARGE, false);

		assertEquals(alcohol1, alcohol2);

	}
}