/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Order class to process orders
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * Order class
 * @author Arik Hasan
 * @version 08/07/2023 
 */
import java.util.ArrayList;
import java.util.Random;

public class Order extends Object implements OrderInterface, Comparable<Order> {
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;

	/**
	 * Constructor
	 * 
	 * @param orderTime
	 * @param orderDay
	 * @param cust
	 */
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderNum = generateOrder();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = cust;
		beverages = new ArrayList<>();
	}

	/**
	 * to generate a random order number
	 * 
	 * @return random order Number
	 */
	public int generateOrder() {
		Random rand = new Random();
		int randInt = rand.nextInt(90001 - 10000) + 10000;
		return randInt;
	}

	/**
	 * to get order number
	 * 
	 * @return order num
	 */
	public int getOrderNo() {
		return orderNum;
	}

	/**
	 * to get order time
	 * 
	 * @return time of order
	 */
	public int getOrderTime() {
		return orderTime;
	}

	/**
	 * to get day of order
	 * 
	 * @return day of order
	 */
	public Day getOrderDay() {
		return orderDay;
	}

	/**
	 * gets the customer
	 * 
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	public Day getDay() {
		return orderDay;
	}

	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if (itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}

		return null;

	}

	public int getTotalItems() {
		return beverages.size();
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	@Override
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		for (Beverage bev : beverages) {
			orderTotal += bev.calcPrice();
		}
		return orderTotal;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int i = 0;
		for (Beverage bev : beverages) {
			if (bev.getType() == type)
				i++;
		}
		return i;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order No: ").append(orderNum).append(", Time: ").append(orderTime).append(", Day: ").append(orderDay)
				.append(", Customer: ").append(customer).append(", Total Amount: $")
				.append(String.format("%.2f", calcOrderTotal())).append("\n");
		for (int i = 0; i < beverages.size(); i++) {
			sb.append("Item ").append(i + 1).append(": ").append(beverages.get(i)).append("\n");
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Order anotherOrder) {
		if (orderNum == anotherOrder.getOrderNo()) {
			return 0;
		} else if (orderNum > anotherOrder.getOrderNo()) {
			return 1;
		} else
			return -1;
	}

	/**
	 * Creates an arraylist of beverages
	 * 
	 * @return new ArrayList of beverages
	 */
	public ArrayList<Beverage> getBeverages() {
		return new ArrayList<>(beverages);
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * gets the number of alcohol drinks
	 * 
	 * @return number of alcohol drinks
	 */
	public int getNumOfAlcoholDrink() {
		int count = 0;
		for (Beverage beverage : beverages) {
			if (beverage instanceof Alcohol) {
				count++;
			}
		}
		return count;
	}
}
