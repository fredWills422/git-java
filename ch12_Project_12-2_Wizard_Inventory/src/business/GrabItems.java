package business;

import java.util.List;

import util.Console;

public interface GrabItems {
	
	public static void grabItem(List<String> nameOfList){
		
		String itemGrabbed = Console.getString("Name: ");
			nameOfList.add(itemGrabbed);
			System.out.println(itemGrabbed +" was added.");
	}
	
}