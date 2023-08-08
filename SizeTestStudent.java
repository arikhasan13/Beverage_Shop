
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Size Test class to check methods
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

public class SizeTestStudent {

	@Test
	public void testEnumValues() {
		Size[] sizes = Size.values();
		assertEquals(3, sizes.length);

		assertEquals(Size.SMALL, sizes[0]);
		assertEquals(Size.MEDIUM, sizes[1]);
		assertEquals(Size.LARGE, sizes[2]);
	}

	@Test
	public void testEnumOrdinal() {
		assertEquals(0, Size.SMALL.ordinal());
		assertEquals(1, Size.MEDIUM.ordinal());
		assertEquals(2, Size.LARGE.ordinal());
	}
}
