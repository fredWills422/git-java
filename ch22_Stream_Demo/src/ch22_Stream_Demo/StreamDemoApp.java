package ch22_Stream_Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StreamDemoApp {

	public static void main(String[] args) {
		
		System.out.println("Initializing List");
		List<Contact> contacts = new ArrayList<>();
		
		System.out.println("Adding contact");
		contacts.add(new Contact("Mike Murach", null, "555-5555"));
		contacts.add(new Contact ("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		System.out.println("============================================");
		System.out.println("Turning my list named contacts into a stream\n"
				+ "that uses the filter method to create a stream which is\n"
				+ "represented by c. That stream contains the contacts that\n"
				+ "match the predicate of the getPhone method returning a\n"
				+ "value of null. Then using the forEach function to loop\n"
				+ "through the elements in the stream and print the value\n"
				+ "returned by the getName method.");
		System.out.println("=============================================");
		contacts.stream().filter(c -> c.getPhone() == null)
						 .forEach(c -> System.out.println(c.getName()));
		System.out.println("=============================================");
		System.out.println("Initializing a List of type Contact named contactsNoPhone\n"
				+ "that equals a sequential Stream that uses the list named contacts\n"
				+ "as its source. That stream uses the filter method, which is available\n"
				+ "to all streams, to create a stream that consist of only the elements\n "
				+ "matching this predicate; getPhone equals equals null.\n"
				+ "The elements in this stream are grouped by the collect method where we\n"
				+ "pass a funtion named toList that comes from an interface called Collectors. ");
		System.out.println("=============================================");
		List<Contact> contactsNoPhone = contacts.stream()
				.filter(c -> c.getPhone()== null)
				.collect(Collectors.toList());
		
		System.out.println("There are " + contactsNoPhone.size()
		                 + " contacts with no phone number.");
		System.out.println("=============================================");
		
		List<String> contactNames = contacts.parallelStream()
				.map(c -> c.getName())
				.collect(Collectors.toList());
		
		contactNames.stream().forEach(str -> System.out.println(str));
		
		System.out.println("=============================================");
		// same as above but passed in lambdas without passing lambda
		List<String> contactNames2 = contacts.stream()
				.map(Contact::getName)
				.collect(Collectors.toList());
		
		contactNames2.stream().forEach(System.out::println);
		System.out.println("=============================================");
		//not in book
		contacts.stream().map(Contact::getName).forEach(System.out::println);
		//not in book
		System.out.println("=============================================");
		String csv = contacts.stream()
				.map(c -> c.getName())
				.reduce("", (a, b)-> a + b + ", ");
		
		csv = csv.substring(0, csv.length() - 2);
		System.out.println("All contacts: " + csv);
		System.out.println("=============================================");
	}

}
