/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Coffee Class to process Coffee
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * Coffee class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_PRICE = 0.5;
	private final double SYRUP_PRICE = 0.5;

	/**
	 * Constructor
	 * 
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	/**
	 * gets if extra shot is taken or not
	 * 
	 * @return true for extra shot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == Size.MEDIUM) {
			price += super.getSIZE_PRICE();
		} else if (super.getSize() == Size.LARGE) {
			price += 2 * super.getSIZE_PRICE();
		}

		if (extraShot) {
			price += SHOT_PRICE;
		}
		if (extraSyrup) {
			price += SYRUP_PRICE;
		}
		return price;
	}

	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;

		Coffee coffee = (Coffee) anotherBev;
		return getBevName().equals(coffee.getBevName()) && getType() == coffee.getType()
				&& getSize() == coffee.getSize() && calcPrice() == coffee.calcPrice() && extraShot == coffee.extraShot
				&& extraSyrup == coffee.extraSyrup;
	}

}
