import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lab9Shopping {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		HashMap<String, Double> prices = new HashMap<>();
		prices.put("banana", 0.99);
		prices.put("milk", 4.21);
		prices.put("cowboy hat", 29.99);
		prices.put("human tooth", 10.01);
		prices.put("cornballer", 99.99);
		prices.put("yum yums", 11.11);
		prices.put("xanax", 4.01);
		prices.put("edible glitter", 3.69);

		System.out.println("Welcome to The Wonderful Emporium of Wonderment! |");
		System.out.println("==================================================");
		/*
		 * for (Map.Entry<String, Double> entry : prices.entrySet()) {
		 * System.out.printf(entry.getKey() + " " + entry.getValue() + "\n"); }
		 * 
		 */
		List<String> menu = new ArrayList<String>(goodMenuItems(prices));
		List<Double> moneys = new ArrayList<Double>(goodMoneyCost(prices));

		for (int i = 0; i < menu.size(); i++) {
			System.out.println((i + 1) + ") " + menu.get(i));
			System.out.println("   $ " + moneys.get(i));
			System.out.println("- - - - - - - - - - -");
		}

		System.out.println("======================");

		List<String> items = new ArrayList<>();
		List<Double> cost = new ArrayList<>();
		
		boolean more = true;
		boolean valid = true;

		System.out.println("What would you like? |");
		System.out.println("======================");

		int iWant = scan.nextInt();
		valid = isTrue(iWant);
		// scan.nextLine();

		while (!valid) {
			System.out.println("I'm sorry that is not an option.");
			System.out.println("Please try again.");
			iWant = scan.nextInt();
			valid = isTrue(iWant);
			// scan.nextLine();
		}

		String choice = menu.get(iWant - 1);
		Double amount = moneys.get(iWant - 1);

		scan.nextLine();

		items.add(choice);
		cost.add(amount);
		System.out.println("======================================");
		System.out.println("Would you like anything else?= (y/n) |");
		System.out.println("======================================");
		more = iDo(scan.nextLine());
		while (more) {

			// for (Map.Entry<String, Double> entry : prices.entrySet()) {
			// System.out.printf(entry.getKey() + " " + entry.getValue() + "\n");
			// }

			for (int i = 0; i < menu.size(); i++) {
				System.out.println((i + 1) + ") " + menu.get(i));
				System.out.println("   $ " + moneys.get(i));
				System.out.println("- - - - - - - - - - -");
			}

			System.out.println("What would you like? |");
			System.out.println("======================");

			iWant = scan.nextInt();
			valid = isTrue(iWant);
			// scan.nextLine();

			while (!valid) {
				System.out.println("I'm sorry that is not an option.");
				System.out.println("Please try again.");
				iWant = scan.nextInt();
				valid = isTrue(iWant);
				// scan.nextLine();
			}

			choice = menu.get(iWant - 1);
			amount = moneys.get(iWant - 1);

			scan.nextLine();

			items.add(choice);
			cost.add(amount);
			System.out.println("======================================");
			System.out.println("Would you like anything else?  (y/n) |");
			System.out.println("======================================");
			more = iDo(scan.nextLine());
		}

		System.out.println("Items in your cart:  |");
		System.out.println("======================");
		HashMap<String, Double> totalMap = new HashMap<>(newMap(items, prices));

		//List<Integer> cartCount = new ArrayList<>(numOfStuff(items,menu));
		
		//for (int it = 1; it <= items.size(); it++) {
		//System.out.println("You got "+ cartCount.get(it)+" "+items + "s, for a total of $"
		//		+ (moneys.get(it)) * (cartCount.get(it)));
		//System.out.println("============================");
		//}
		 for (Map.Entry<String, Double> entry : totalMap.entrySet()) {
		 System.out.printf(entry.getKey() + " " + entry.getValue() + "\n"); }
		 System.out.println("============================");
		System.out.println("Your total today comes to:  ");
		System.out.println(sum(cost));
		// System.out.println("$" + cashTotal(totalMap));
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
		System.out.println("====================================\n \n");
		System.out.println("Have a nice day!");

		// System.out.println("My List : " + items);
		// System.out.println("\nHere are the duplicate elements from list : " +
		// accuCart(items));
		scan.close();
	}

	public static List<Integer> numOfStuff(List<String> thangs, List<String> price) {
		List<String> stuff = new ArrayList<>(thangs);
		List<Integer> numStuff = new ArrayList<>();
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
		
			for (int i = 0; i < stuff.size(); i++) {
				if (price.indexOf(i)==0) {
					a++;
				}	else if (price.indexOf(i)==1) {
					b++;
				}	else if (price.indexOf(i)==2) {
					c++;
				}	else if (price.indexOf(i)==3) {
					d++;
				}	else if (price.indexOf(i)==4) {
					e++;
				}	else if (price.indexOf(i)==5) {
					f++;
				}	else if (price.indexOf(i)==6) {
					g++;
				}	else if (price.indexOf(i)==7) {
					h++;
				}
			}
			
		numStuff.add(a);
		numStuff.add(b);
		numStuff.add(c);
		numStuff.add(d);
		numStuff.add(e);
		numStuff.add(f);
		numStuff.add(g);
		numStuff.add(h);
		return numStuff;
	}

	public static Set<String> accuCart(List<String> dupes) {

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String finder : dupes) {
			if (!set1.add(finder)) {
				setToReturn.add(finder);
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

	private static ArrayList<Double> goodMoneyCost(HashMap<String, Double> daMap) {
		ArrayList<Double> money = new ArrayList<>();
		for (double value : daMap.values()) {
			money.add(value);
		}
		return money;
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

	public static boolean isTrue(int input) {
		return (input <= 8 && input >= 1);
	}

	public static boolean iDo(String input) {
		input.toLowerCase();
		return (input
				.matches("(yes)|(y)|(yeah)|(yah)|(yes sir)|(you bet your biscuit)|(you're damn right)|(yee)|(yeet)"));
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
