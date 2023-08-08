/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: BevShop Class to process beverages in shop
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * BevShop class
 * @author Arik Hasan
 * @version 08/07/2023 
 */
import java.util.ArrayList;

public class BevShop extends Object implements BevShopInterface {
	private int alcoholOrderNum;
	private int currentOrderList;
	private ArrayList<Order> orders;

	/**
	 * Constructor
	 */
	public BevShop() {
		orders = new ArrayList<>();
	}

	@Override

	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (alcoholOrderNum < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	public int getNumOfAlcoholDrink() {
		return alcoholOrderNum;
	}

	public boolean isValidAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderList = orders.indexOf(order);
		alcoholOrderNum = 0;
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderList).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(currentOrderList).addNewBeverage(bevName, size);
		alcoholOrderNum++;
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrderList).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public int findOrder(int orderNo) {
		for (int count = 0; count < orders.size(); count++) {
			if (orders.get(count).getOrderNo() == orderNo) {
				return count;
			}
		}
		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		double sale = 0.0;
		for (Order ord : orders) {
			if (ord.getOrderNo() == orderNo) {
				for (Beverage bev : ord.getBeverages()) {
					sale += bev.calcPrice();
				}
			}
		}
		return sale;
	}

	public double totalMonthlySale() {
		double saleTotal = 0.0;
		for (Order ord : orders) {
			for (Beverage bev : ord.getBeverages()) {
				saleTotal += bev.calcPrice();
			}
		}
		return saleTotal;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getCurrentOrder() {
		return orders.get(currentOrderList);
	}

	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	public void sortOrders() {
		for (int i = 0; i < orders.size() - 1; i++) {
			int minOrderNumIdx = i;
			for (int s = i + 1; s < orders.size(); s++) {
				if (orders.get(s).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) {
					minOrderNumIdx = s;
				}
			}
			Order temp = orders.get(minOrderNumIdx);
			orders.set(minOrderNumIdx, orders.get(i));
			orders.set(i, temp);
		}
	}

	public String toString() {
		String s = "Monthly Orders\n";
		for (Order ord : orders) {
			s += ord.toString();
		}
		s += "Total Sale: " + totalMonthlySale();
		return s;
	}

}
