import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListsPractice {

	public static void main(String[] args) {

		int[] numbers = new int[4];
		numbers[0]=1;
		numbers[1]=2;
		numbers[2]=47;
		numbers[3]=4;
		
		System.out.println(max(numbers));
		
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(6);
		nums.add(9);
		
		System.out.println(min(nums));
		
		Set<Double> average = new HashSet<>();
		average.add(3.46);
		average.add(3.05);
		average.add(6.04);
		
		System.out.println(average(average));
		
		String[] map = new String[3];
		map[0]="Hello";
		map[1]="Goodbye";
		map[2]="Okay";
		
		System.out.println(newMap(map));
		
	}
	
	private static HashMap<String, Integer> newMap(String[] words){
		
		HashMap<String, Integer> someName = new HashMap<>();
		
		for (String s : words) {
		someName.put(s, s.length());
		}  return someName;
	}
	
	private static double average(Set<Double> dubs) {
		double total = 0;
		for (double i : dubs) {
			total+=i;
		}	return (total/dubs.size());
		
	}
	
	private static int max(int[] nums) {
		int max = nums[0];
		for (int i : nums) {
			if (i>max) {
				max = i;
			} 
		} return max;
			
	}
	
	private static int min(List<Integer> numbers) {
		int min = numbers.get(0);
		for (int i : numbers) {
			if (i < min) {
				min = i;
			}
		}	return min;
	}
	
	
}
