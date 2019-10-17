package business;

import java.util.List;

import util.Console;

public interface EditItems {
	
	public static void editItem(List<String> nameOfList){
		int itemBeingReplaced = Console.getIntInRange("Number: ",0,nameOfList.size());
		nameOfList.set(itemBeingReplaced, Console.getString("Updated name: "));
		System.out.println("Item number " + (itemBeingReplaced)+" was updated.");
	}
	
}
