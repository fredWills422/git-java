public class Movie {
	
	private int id = 0;
	private String title = "";
	private String rating = "";
	private int year = 0;
	private String director = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String toString() {
		String message = "ID: " + id + "\n"
				+ "Title: " + title + "\n"
				+ "Rating: " + rating + "\n"
				+ "Year of release: " + year + "\n"
				+ "Director: " + director;
		return message;
	}
	
}
