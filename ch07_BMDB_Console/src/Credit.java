public class Credit {
	
	private int id = 0;
	private int movieID = 0;
	private int actorID = 0;
	private String role = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getActorID() {
		return actorID;
	}
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		String message = "ID: " + id + "\n"
				+ "MovieID: " + movieID + "\n"
				+ "ActorID: " + actorID + "\n"
				+ "Role: " + role;
		return message;
	}
	
}
