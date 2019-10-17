package business;

import java.util.ArrayList;
import java.util.List;


public class Wizard implements ShowItems, GrabItems, DropItems, EditItems{
	
	private String woodenStaff;
	private String wizardHat;
	private String clothShoes;
	public static List<String> wizardInventoryList = new ArrayList<>();
	 
	
	public Wizard() {
		
	}
	
	public Wizard(String woodenStaff, String wizardHat, String clothShoes) {
		super();
		this.woodenStaff = woodenStaff;
		this.wizardHat = wizardHat;
		this.clothShoes = clothShoes;
	}

	public String getWoodenStaff() {
		woodenStaff = "wooden staff";
		return woodenStaff;
	}

	public void setWoodenStaff(String woodenStaff) {
		this.woodenStaff = woodenStaff;
	}

	public String getWizardHat() {
		wizardHat= "wizard hat";
		return wizardHat;
	}

	public void setWizardHat(String wizardHat) {
		this.wizardHat = wizardHat;
	}

	public String getClothShoes() {
		clothShoes = "cloth shoes";
		return clothShoes;
	}

	public void setClothShoes(String clothShoes) {
		this.clothShoes = clothShoes;
	}
	
	public String toString() {
		String message = "1. " + woodenStaff + "\n"
				+ "2. " + wizardHat + "\n"
				+ "3. " + clothShoes;
		return message;
	}
	
}
