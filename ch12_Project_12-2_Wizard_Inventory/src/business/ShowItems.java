package business;

import java.util.List;

public interface ShowItems {
	//for (String wizardItem inside wizardInventory
	public static void showItems(List<String> nameOfList) {
		
		for (String listItem: nameOfList) {	
		System.out.println(listItem);
		}
		
	}
	
}
