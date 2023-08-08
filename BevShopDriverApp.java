/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Driver class to run program
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arik Hasan
*/

/**
 * BevShop Driver class
 * 
 * @author Arik Hasan
 * @version 08/07/2023
 */
public class BevShopDriverApp {

	public static void main(String[] args) {

		int tempAge, tempOrderNo;

		Customer tempCustomer;

		BevShop bevs = new BevShop();

		System.out.println(bevs.getMaxOrderForAlcohol());

		System.out.println(bevs.getMinAgeForAlcohol());

		System.out.println("Start a new order:");

		bevs.startNewOrder(12, Day.MONDAY, "John", 23);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal()); // 0.0

		tempCustomer = bevs.getCurrentOrder().getCustomer();

		tempCustomer.setName("John");

		tempCustomer.setAge(23);

		System.out.println(bevs.getCurrentOrder().getCustomer().getName());

		System.out.println(bevs.getCurrentOrder().getCustomer().getAge());

		tempAge = bevs.getCurrentOrder().getCustomer().getAge();

		System.out.println(bevs.isValidAge(tempAge));

		if (bevs.isValidAge(tempAge)) {

			System.out.println("Add alcohol drink");

			bevs.processAlcoholOrder("Mohito", Size.SMALL);
		}

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println(bevs.isEligibleForMore());

		System.out.println("Add second alcohol drink");

		bevs.processAlcoholOrder("tonic", Size.LARGE);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println(bevs.getNumOfAlcoholDrink());

		System.out.println("Add third alcohol drink");

		bevs.processAlcoholOrder("wine", Size.SMALL);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println(bevs.getNumOfAlcoholDrink());
		if (!bevs.isEligibleForMore())

			System.out.println("Maximum alcohol drink for this order");

		System.out.println("Add a COFFEE to order");
		bevs.processCoffeeOrder("cappuchino", Size.SMALL, true, true);

		System.out.println(bevs.getNumOfAlcoholDrink());

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		tempOrderNo = bevs.getCurrentOrder().getOrderNo();

		if (bevs.findOrder(tempOrderNo) != -1) {

			System.out.println("Total on the Order:" + bevs.totalOrderPrice(tempOrderNo));

		}

		else

			System.out.println("order not found! Should not get to here!");

		System.out.println("Start a new order");

		bevs.startNewOrder(10, Day.SUNDAY, "Mary", 12);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println("Add a SMOOTHIE to order");

		bevs.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println("Add a COFFEE to order");

		bevs.processCoffeeOrder("Latte", Size.MEDIUM, false, false);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println(bevs.getNumOfAlcoholDrink());

		if (bevs.isValidAge(bevs.getCurrentOrder().getCustomer().getAge())) {

			System.out.println("Should not get to here!!!");

			bevs.processAlcoholOrder("mohito", Size.MEDIUM);

		} else

			System.out.println("Age not appropriate for alcohol drink!!");

		tempOrderNo = bevs.getCurrentOrder().getOrderNo();

		if (bevs.findOrder(tempOrderNo) != -1)

			System.out.println("Total on the Order:" + bevs.totalOrderPrice(tempOrderNo));

		else {

			System.out.println("Order not found. Should no get to here!!");

		}

		int numOfFruits = 6;

		if (bevs.isMaxFruit(numOfFruits)) {

			System.out.println("Maximum number of fruits\n");

		}

		numOfFruits = 5;

		bevs.processSmoothieOrder("Detox", Size.LARGE, numOfFruits, false);

		System.out.println("Total on the Order:" + bevs.getCurrentOrder().calcOrderTotal());

		System.out.println("Total amount for all orders:" + bevs.totalMonthlySale());
	}

}