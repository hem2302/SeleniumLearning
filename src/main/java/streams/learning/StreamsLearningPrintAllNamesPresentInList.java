package streams.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsLearningPrintAllNamesPresentInList {
	public static void main(String[] args) {
		// Print all the names where the length of the string is greater than four(4)

		System.out.println("***Print all the names which are the length greater than 4***");
		ArrayList<String> names = new ArrayList<String>();
		names.add("hema");
		names.add("kumar");
		names.add("hemakumar");
		names.add("hari");
		names.add("hemamalini");

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// Limt the result with 1 entry
		System.out.println("Limt the result with 1 entry. Print only the first entry");
		System.out.println();
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}
}
