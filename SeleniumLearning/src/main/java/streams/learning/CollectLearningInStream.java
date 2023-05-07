package streams.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectLearningInStream {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("hema");
		names.add("hemakumar");
		names.add("hemaa");
		names.add("hemamalini");

		List<String>ls = names.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
	}
}
