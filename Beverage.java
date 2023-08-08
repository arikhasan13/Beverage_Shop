/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Beverage Class to process beverages
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * Beverage class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;

	/**
	 * Constructor
	 */
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}

	public double getBasePrice() {
		return BASE_PRICE;
	}

	public Type getType() {
		return type;
	}

	public String getBevName() {
		return bevName;
	}

	public Size getSize() {
		return size;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	public double addSizePrice() {
		switch (size) {
		case SMALL:
			return 0;
		case MEDIUM:
			return SIZE_PRICE;
		case LARGE:
			return (2 * SIZE_PRICE);
		default:
			throw new IllegalArgumentException("Invalid size");
		}
	}

	public String toString() {
		return bevName + "," + size;
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Beverage beverage = (Beverage) anotherBev;
		return bevName.equals(beverage.bevName) && type == beverage.type && size == beverage.size;
	}

	/**
	 * abstract method
	 * 
	 * @return
	 */
	public abstract double calcPrice();

}
