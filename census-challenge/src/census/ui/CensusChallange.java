package census.ui;

import java.util.HashMap;

import census.business.City;

public class CensusChallange {

	public static void main(String[] args) {
		
		City c1 = new City("city1", 18897109);
		City c2 = new City("city2", 12828837);
		City c3 = new City("city3", 9461105);
		City c4 = new City("city4", 6371773);
		City c5 = new City("city5", 5965343);
		City c6 = new City("city6", 5946800);
		City c7 = new City("city7", 5582170);
		City c8 = new City("city8", 5564635);
		City c9 = new City("city9", 5268860);
		City c10 = new City("city10", 4552402);
		City c11 = new City("city11", 4335391);
		City c12 = new City("city12", 4296250);
		City c13 = new City("city13", 4224851);
		City c14 = new City("city14", 4192887);
		City c15 = new City("city15", 3439809);
		City c16 = new City("city16", 3279833);
		City c17 = new City("city17", 3095313);
		City c18 = new City("city18", 2812896);
		City c19 = new City("city19", 2783243);
		City c20 = new City("city20", 2710489);
		City c21 = new City("city21", 2543482);
		City c22 = new City("city22", 2356285);
		City c23 = new City("city23", 2226009);
		City c24 = new City("city24", 2149127);
		City c25 = new City("city25", 2142508);
		City c26 = new City("city26", 2134411);
		
		HashMap<String, City> census = new HashMap<>();
		
		census.put("city1", c1);
		census.put("city2", c2);
		census.put("city3", c3);
		census.put("city4", c4);
		census.put("city5", c5);
		census.put("city6", c6);
		census.put("city7", c7);
		census.put("city8", c8);
		census.put("city9", c9);
		census.put("city10", c10);
		census.put("city11", c11);
		census.put("city12", c12);
		census.put("city13", c13);
		census.put("city14", c14);
		census.put("city15", c15);
		census.put("city16", c16);
		census.put("city17", c17);
		census.put("city18", c18);
		census.put("city19", c19);
		census.put("city20", c20);
		census.put("city21", c21);
		census.put("city22", c22);
		census.put("city23", c23);
		census.put("city24", c24);
		census.put("city25", c25);
		census.put("city26", c26);
		
		System.out.println(census);
		System.out.println(census.size());
		
		
		
	}

}
