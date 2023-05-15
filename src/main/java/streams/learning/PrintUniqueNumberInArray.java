package streams.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUniqueNumberInArray {
	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(9);
		numbers.add(10);
		numbers.add(1);
		numbers.add(20);
		numbers.add(90);
		numbers.add(90);

		numbers.stream().distinct().forEach(s -> System.out.println(s));

		List<Integer> nu = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(nu.get(2));
	}
}
