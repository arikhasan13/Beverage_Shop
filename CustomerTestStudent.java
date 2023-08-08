/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Customer Test class to check methods
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

public class CustomerTestStudent {

	@Test
	public void testConstructorWithNameAndAge() {
		// Arrange
		String name = "Peter Parker";
		int age = 25;

		// Act
		Customer customer = new Customer(name, age);

		// Assert
		assertEquals(name, customer.getName());
		assertEquals(age, customer.getAge());
	}

	@Test
	public void testCopyConstructor() {

		String name = "Peter Parker";
		int age = 25;
		Customer originalCustomer = new Customer(name, age);

		Customer copiedCustomer = new Customer(originalCustomer);

		assertEquals(name, copiedCustomer.getName());
		assertEquals(age, copiedCustomer.getAge());
	}
}
