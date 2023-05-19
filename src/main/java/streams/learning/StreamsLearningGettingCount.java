package streams.learning;

import java.util.ArrayList;

public class StreamsLearningGettingCount {
	public static void main(String[] args) {
//For Streams
//There is no life for the intermediate operation if there is no terminal operation
//Terminal operation will execute only if the intermediate operation(filter) returns true.

		ArrayList<String> names = new ArrayList<String>();
		names.add("hema");
		names.add("hemakumar");
		names.add("kumar");
		names.add("Hari");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i).toLowerCase();
			if (name.startsWith("h")) {
				count++;
			}
		}
		System.out.println(count);

		// using Stream getting count with filter operation
		System.out.println("*** USING STREAM GETTING COUNT WITH FILTER OPETATION***");
		// long c = names.stream().filter(s -> s.startsWith("h")).filter(s ->
		// s.toLowerCase()).count();
		long c = names.stream().map(s -> s.toLowerCase()).filter(s -> s.startsWith("h")).count();
		System.out.println("The count using stream is : "+c);
	}
}
