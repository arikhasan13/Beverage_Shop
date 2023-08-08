
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Type Test class to check methods
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

public class TypeTestStudent {

	@Test
	public void testEnumValues() {
		Type[] types = Type.values();
		assertEquals(3, types.length);

		assertEquals(Type.COFFEE, types[0]);
		assertEquals(Type.SMOOTHIE, types[1]);
		assertEquals(Type.ALCOHOL, types[2]);
	}

	@Test
	public void testEnumOrdinal() {
		assertEquals(0, Type.COFFEE.ordinal());
		assertEquals(1, Type.SMOOTHIE.ordinal());
		assertEquals(2, Type.ALCOHOL.ordinal());
	}

}
