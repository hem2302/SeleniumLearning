package streams.learning;

import java.util.Arrays;
import java.util.List;

public class PrintNamesWithUpperCase {
	// Print the names of length greater than 4 with uppercase
	public static void main(String[] args) {
		String[] arr = { "hema", "hemakumar", "hemamalini", "hemaa" };
		List<String> names = Arrays.asList(arr);
		for (String s : names) {
			System.out.println(s);
		}
		System.out.println("*** Print the names ends with a changing with the names to uppercase ***");
		names.stream().map(s -> s.toUpperCase()).filter(s -> s.endsWith("A")).forEach(s -> System.out.println(s));

		// Print all the names starts with the letter "h" with uppercase and sort it
		System.out.println("Print all the names starts with the letter h with upper case and also sort it");
		names.stream().map(s->s.toUpperCase()).filter(s->s.startsWith("H")).sorted().forEach(s->System.out.println(s));
	}
}
