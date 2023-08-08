/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Smoothie class to process smoothie orders
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * Smoothie class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */
public class Smoothie extends Beverage {
	private int fruitNum;
	private boolean proteinPowder;
	private final double PROTEIN_PRICE = 1.5;
	private final double FRUIT_PRICE = 0.5;

	/**
	 * Constructor
	 * 
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		fruitNum = numOfFruits;
		proteinPowder = addProtein;
	}

	public int getNumOfFruits() {
		return fruitNum;
	}

	/**
	 * gets if protein powder is added or not
	 * 
	 * @return true if protein powder is added
	 */
	public boolean getAddProtein() {
		return proteinPowder;
	}

	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + proteinPowder + "," + fruitNum + "," + calcPrice();
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == Size.SMALL) {
			price += super.addSizePrice();
		} else if (super.getSize() == Size.MEDIUM) {
			price += super.addSizePrice();
		} else if (super.getSize() == Size.LARGE) {
			price += super.addSizePrice();
		}
		price += fruitNum * FRUIT_PRICE;
		if (proteinPowder)
			price += PROTEIN_PRICE;
		return price;
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		if (!super.equals(anotherBev))
			return false; // Invoke superclass equals
		Smoothie smoothie = (Smoothie) anotherBev;
		return fruitNum == smoothie.fruitNum && proteinPowder == smoothie.proteinPowder;
	}

}
