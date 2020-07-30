import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lab9Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> prices = new HashMap<>();

		prices.put("banana", 0.99);
		prices.put("milk", 4.20);
		prices.put("cowboy hat", 29.99);
		prices.put("human tooth", 10.00);
		prices.put("cornballer", 99.99);
		prices.put("yum yums", 11.11);
		prices.put("xanax", 4.00);
		prices.put("edible glitter", 3.69);
		
		
		List<String> menu = new ArrayList<String>(goodMenuItems(prices));
		
		for (int i = 0; i< menu.size(); i++) {
		
		System.out.println((i+1) + ") " + menu.get(i));
		}
		
		boolean more = true;
		boolean valid;
		System.out.println("Welcome to The Wonderful Emporium of Wonderment! |");
		System.out.println("==================================================");
		for (Map.Entry<String, Double> entry : prices.entrySet()) {
			System.out.printf(entry.getKey() + " " + entry.getValue() + "\n");
		}
		System.out.println("======================");
		List<String> items = new ArrayList<>();
		List<Double> cost = new ArrayList<>();

		System.out.println("What would you like? |");
		System.out.println("======================");

		String choice = scan.nextLine();
		valid = isTrue(choice);
		
		while (!valid) {
			System.out.println("I'm sorry that is not an option.");
			System.out.println("Please try again.");
			choice = scan.nextLine();
			valid = isTrue(choice);
		}
		
		items.add(choice);
		cost.add(prices.get(choice));
		System.out.println("======================================");
		System.out.println("Would you like anything else?= (y/n) |");
		System.out.println("======================================");
		more = iDo(scan.nextLine());
		while (more) {

			for (Map.Entry<String, Double> entry : prices.entrySet()) {
				System.out.printf(entry.getKey() + " " + entry.getValue() + "\n");
			}
			
			
			System.out.println("======================");
			System.out.println("What would you like? |");
			System.out.println("======================");
			choice = scan.nextLine();
			items.add(choice);
			cost.add(prices.get(choice));
			System.out.println("=====================================");
			System.out.println("Would you like anything else? (y/n) |");
			System.out.println("=====================================");
			more = iDo(scan.nextLine());
		}

		System.out.println("Items in your cart:  |");
		System.out.println("======================");
		HashMap<String, Double> totalMap = new HashMap<>(newMap(items, prices));
		System.out.println(cart(totalMap));

		System.out.println("============================");
		System.out.println("Your total today comes to:  ");
		System.out.println("$" + cashTotal(totalMap));
		System.out.println("============================");
		// System.out.println(newMap(items, prices));

		System.out.println("The most expensivest item you bought today was: ");
		System.out.println("$" + max(cost));
		System.out.println("=================================================");
		// double total = sum(cost);
		// BigDecimal average1= BigDecimal.valueOf(average2);
		// System.out.println(total1);
		System.out.println("The least expensivest item you bought today was:");
		System.out.println("$" + min(cost));
		System.out.println("================================================");

		System.out.println("The average cost of your items was:");
		System.out.println("$" + average(cost));
		// BigDecimal average2= BigDecimal.valueOf(average1);
		// System.out.println(average2);
		System.out.println("====================================");
		System.out.println("Have a nice day!");
		
		
		System.out.println("My List : " + items);
		System.out.println("\nHere are the duplicate elements from list : " + accuCart(items));
		scan.close();
	}

	//private static ArrayList<String> accuCart(List<String> words) {		
	//}
	
	public static Set<String> accuCart(List<String> listContainingDuplicates) {
		 
		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();
 
		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}

	private static ArrayList<String> goodMenuItems(HashMap<String, Double> map) {
		ArrayList<String> theGoods = new ArrayList<>();
		for (String name : map.keySet()) {
			theGoods.add(name);
		}
		return theGoods;
	}
	
	private static ArrayList<String> cart(HashMap<String, Double> issaMap) {
		ArrayList<String> theCart = new ArrayList<>();
		for (String name : issaMap.keySet()) {
			theCart.add(name);
		}
		return theCart;
	}

	private static BigDecimal cashTotal(HashMap<String, Double> daMap) {
		double subTotal = 0;
		for (double value : daMap.values()) {
			subTotal += value;
		}
		BigDecimal subTotal1 = BigDecimal.valueOf(subTotal);
		return subTotal1;
	}

	private static HashMap<String, Double> newMap(List<String> words, HashMap<String, Double> mappy) {

		HashMap<String, Double> someName = new HashMap<>();
		int counter = 1;

		double d;
		for (String s : words) {
			d = mappy.get(s);
			someName.put(counter + s, d);
			counter += 1;
		}
		return someName;
	}

	private static double min(List<Double> dubs) {
		double minDub = dubs.get(0);
		for (Double d : dubs) {
			if (d < minDub) {
				minDub = d;
			}
		}
		return minDub;
	}

	private static double max(List<Double> dubs) {
		double maxDub = dubs.get(0);
		for (Double d : dubs) {
			if (d > maxDub) {
				maxDub = d;
			}
		}
		return maxDub;
	}

	// private static Set<String> theSet(String item){
	// Set<String> items = new HashSet<>();
	//
	// }

	private static double sum(List<Double> nums) {
		double sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			double num = nums.get(i);
			sum += num;
		}
		return sum;
	}
	
	public static boolean isTrue(String input) {
		input.toLowerCase();
		if (input.matches("(corn baller)|(xanax)|(cowboy hat)|(milk)|(banana)|(edible glitter)|(human tooth)|(yum yums)")) {
			return true;
		}  else 
			return false;
	}
	
	public static boolean iDo(String input) {
		input.toLowerCase();
		if (input.matches("(yes)|(y)|(yeah)|(yah)|(yes sir)|(you bet your biscuit)|(you're damn right)|(yee)")) {
			return true;
		} else
			return false;
	}

	private static BigDecimal average(List<Double> dubs) {
		double total = 0;
		for (double i : dubs) {
			total += i;
		}
		double average1 = total / dubs.size();
		BigDecimal average2 = BigDecimal.valueOf(average1);
		return average2;
	}
}
