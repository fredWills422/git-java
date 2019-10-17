package business;

import java.lang.reflect.Array;
import java.util.List;

import util.Console;

public interface DropItems {

	public static void dropItem(List<String> nameOfList){
		int itemDropped = Console.getIntInRange("Number: ",1,(nameOfList.size()+1));
		Object[]nameOfListArray = nameOfList.toArray();
		System.out.println(Array.get(nameOfListArray, (itemDropped-1)) + " was dropped.");
		nameOfList.remove((itemDropped-1));
	}
	
}
