/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Customer Class to process customers
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * Customer class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */
public class Customer {
	private String name;
	private int age;

	/**
	 * Constructor
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Overloaded Constructor
	 * 
	 * @param c instance of the Customer object
	 */
	public Customer(Customer c) {
		this.name = c.getName();
		this.age = c.getAge();
	}

	/**
	 * gets age
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * sets age
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + ", " + age + "y/o";
	}
}
