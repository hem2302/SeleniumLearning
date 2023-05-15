package streams.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class MergeTwoArrayListUsingStream {
	public static void main(String[] args) {

		// Merge Two Array List using Stream
		String[] array = { "hema", "kumar", "hemakumar", "hemamalini", "hemaa" };
		List<String> list1 = Arrays.asList(array);
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("chennai");
		list2.add("canada");
		list2.add("canteen");
		list2.add("uk");
		list2.add("usa");
		boolean aaa = list1.equals(list2);
		System.out.println(aaa);
		System.out.println("*** Merge two arraylist using streams in sorted mode ***");
		Stream<String> newStream = Stream.concat(list1.stream(), list2.stream());
	//	newStream.sorted().forEach(s -> System.out.println(s));
		
		//check whether a particular name is present or not. return true if present, if not, return false. no need to print
		//for this action, we need to use match();
		boolean matchorNot = newStream.anyMatch(a->a.equalsIgnoreCase("chennai"));
		System.out.println(matchorNot);
		Assert.assertTrue(matchorNot);
		
	
		
	}
}
