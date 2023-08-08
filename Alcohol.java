/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Alcohol Class to process Alcohol
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/
/**
 * Alcohol class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */
public class Alcohol extends Beverage {
	private boolean inWeekend;
	private final double WEEKEND_FEE = 0.6;

	/**
	 * Constructor
	 */
	public Alcohol(String bevName, Size size, boolean inWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.inWeekend = inWeekend;
	}

	/**
	 * Checks whether it is a weekend or not
	 * 
	 * @return true if it is a weekend
	 */
	public boolean isWeekend() {
		if (inWeekend)
			return true;
		else
			return false;
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();

		if (super.getSize() == Size.MEDIUM) {
			price += super.getSIZE_PRICE();
		} else if (super.getSize() == Size.LARGE) {
			price += 2 * super.getSIZE_PRICE();
		}

		if (inWeekend) {
			price += WEEKEND_FEE;
		}

		return price;
	}

	@Override

	public String toString() {
		return getBevName() + "," + getSize() + "," + inWeekend + "," + calcPrice();
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Alcohol alcohol = (Alcohol) anotherBev;
		return getBevName().equals(alcohol.getBevName()) && getType() == alcohol.getType()
				&& getSize() == alcohol.getSize() && calcPrice() == alcohol.calcPrice()
				&& inWeekend == alcohol.isWeekend();
	}
}
