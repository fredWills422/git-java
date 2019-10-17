package ui;

import java.util.Arrays;
import business.DropItems;
import business.EditItems;
import business.GrabItems;
import business.ShowItems;
import business.Wizard;
import util.Console;

public class WizardInventoryApp {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("The Wizard Inventory Game\n");
		
		Wizard.wizardInventoryList.addAll(Arrays.asList("wooden staff", "wizard hat", "cloth shoes"));
		
		System.out.println("COMMAND MENU \n"
				+"show - Show all items\n"
				+"grab - Grab an item\n"
				+"drop - Drop an item\n"
				+"edit - Edit an item\n"
				+"exit - Exit program");
		
		String chosenCommand = "";
		while(!chosenCommand.equalsIgnoreCase("exit")) {
			
			chosenCommand = Console.getString("\nCommand: ");
			switch (chosenCommand) {
			case "show":
				ShowItems.showItems(Wizard.wizardInventoryList);
				break;
			case "grab":
				if(Wizard.wizardInventoryList.size()>=4) {
					System.out.println("You can't carry anymore items, drop something first.");
					continue;
				}else if(Wizard.wizardInventoryList.size()<4) {
					GrabItems.grabItem(Wizard.wizardInventoryList);
					continue;
				}
				break;
			case "drop":
				DropItems.dropItem(Wizard.wizardInventoryList);
				break;
			case "edit":
				EditItems.editItem(Wizard.wizardInventoryList);
				break;
			case "exit":
				break;
			default:
				System.out.println("enter a valid command");
			}
			
		}
		System.out.println("bye!");
		
	}
	
	
	
}
