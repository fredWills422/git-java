package census.business;

public class City {

	private String name;
	private int population;
	
	public City() {}
	
	public City(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", population=" + population + "]";
	}
	
	
}
