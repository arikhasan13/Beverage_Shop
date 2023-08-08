
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Smoothie Test class to check methods
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

public class SmoothieTestStudent {

	@Test
	public void testCalcPrice() {
		Smoothie smoothie1 = new Smoothie("Berry Baja", Size.SMALL, 3, true);
		Smoothie smoothie2 = new Smoothie("Mango Fire", Size.MEDIUM, 5, false);

		assertEquals(5, smoothie1.calcPrice(), 0.001);

		assertEquals(5.5, smoothie2.calcPrice(), 0.001);
	}

	@Test
	public void testToString() {
		Smoothie smoothie = new Smoothie("Green Mix", Size.LARGE, 2, true);
		String expectedString = "Green Mix,LARGE,true,2," + smoothie.calcPrice();
		assertEquals(expectedString, smoothie.toString());
	}

	@Test
	public void testEquals() {
		Smoothie smoothie1 = new Smoothie("Strawberry Smoothie", Size.MEDIUM, 4, false);
		Smoothie smoothie2 = new Smoothie("Strawberry Smoothie", Size.MEDIUM, 4, false);

		assertEquals(smoothie1, smoothie2);

	}

}
