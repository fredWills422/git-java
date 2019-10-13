
public class BMDBApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Movie Data Base App!\n ");
		
		System.out.println("Lets put a actor in the database.\n ");
		
		Actor actor1 = new Actor();
		
		int actor1Id = Console.getInt("Enter actor id: ");
		String actor1FirstName = Console.getString("Enter actors first name: ");
		String actor1LastName = Console.getString("Enter actors last name: ");
		String actor1Gender = Console.getString("Enter actors gender: ");
		String actor1BirthDate = Console.getString("Enter actors birthdate: ");
		
		actor1.setId(actor1Id);
		actor1.setFirstName(actor1FirstName);
		actor1.setLastName(actor1LastName);
		actor1.setGender(actor1Gender);
		actor1.setBirthDate(actor1BirthDate);
		
		System.out.println(actor1.toString());
		
		System.out.println("Lets put another actor in the database.\n ");
		
		Actor actor2 = new Actor();
		
		int actor2Id = Console.getInt("Enter actor id: ");
		String actor2FirstName = Console.getString("Enter actors first name: ");
		String actor2LastName = Console.getString("Enter actors last name: ");
		String actor2Gender = Console.getString("Enter actors gender: ");
		String actor2BirthDate = Console.getString("Enter actors birthdate: ");
		
		actor2.setId(actor2Id);
		actor2.setFirstName(actor2FirstName);
		actor2.setLastName(actor2LastName);
		actor2.setGender(actor2Gender);
		actor2.setBirthDate(actor2BirthDate);
		
		System.out.println(actor2.toString());
		
		System.out.println("Lets put another actor in the database.\n ");
		
		Actor actor3 = new Actor();
		
		int actor3Id = Console.getInt("Enter actor id: ");
		String actor3FirstName = Console.getString("Enter actors first name: ");
		String actor3LastName = Console.getString("Enter actors last name: ");
		String actor3Gender = Console.getString("Enter actors gender: ");
		String actor3BirthDate = Console.getString("Enter actors birthdate: ");
		
		actor3.setId(actor3Id);
		actor3.setFirstName(actor3FirstName);
		actor3.setLastName(actor3LastName);
		actor3.setGender(actor3Gender);
		actor3.setBirthDate(actor3BirthDate);
		
		System.out.println(actor3.toString());
		
		System.out.println("Lets put a movie in the database.\n ");
		
		Movie movie1 = new Movie();
		
		int movie1Id = Console.getInt("Enter movie id: ");
		String movie1Title = Console.getString("Enter the title: ");
		String movie1Rating = Console.getString("Enter a rating: ");
		int movie1Year = Console.getInt("Enter year of release: ");
		String movie1Director = Console.getString("Enter the director: ");
		
		movie1.setId(movie1Id);
		movie1.setTitle(movie1Title);
		movie1.setRating(movie1Rating);
		movie1.setYear(movie1Year);
		movie1.setDirector(movie1Director);
		
		System.out.println(movie1.getId());
		System.out.println(movie1.getTitle());
		System.out.println(movie1.getRating());
		System.out.println(movie1.getYear());
		System.out.println(movie1.getDirector());;
		
		System.out.println(movie1.toString());
		
		System.out.println("Lets put another movie in the database.\n ");
		
		Movie movie2 = new Movie();
		
		int movie2Id = Console.getInt("Enter movie id: ");
		String movie2Title = Console.getString("Enter the title: ");
		String movie2Rating = Console.getString("Enter a rating: ");
		int movie2Year = Console.getInt("Enter year of release: ");
		String movie2Director = Console.getString("Enter the director: ");
		
		movie2.setId(movie2Id);
		movie2.setTitle(movie2Title);
		movie2.setRating(movie2Rating);
		movie2.setYear(movie2Year);
		movie2.setDirector(movie2Director);
		
		System.out.println(movie2.toString());
		
		System.out.println("Now lets complete one of the credits.\n ");
		
		Credit role1 = new Credit();
		
		int role1Id = Console.getInt("Enter role id: ");
		int role1MovieID = Console.getInt("Enter movie id: ");
		int role1ActorID = Console.getInt("Enter actor id:");
		String role1Role = Console.getString("Enter role: ");
		
		role1.setId(role1Id);
		role1.setMovieID(role1MovieID);
		role1.setActorID(role1ActorID);
		role1.setRole(role1Role);
		
		System.out.println(role1.toString());
		
		System.out.println("Now lets complete another one of the credits.\n ");
		
		Credit role2 = new Credit();
		
		int role2Id = Console.getInt("Enter role id: ");
		int role2MovieID = Console.getInt("Enter movie id: ");
		int role2ActorID = Console.getInt("Enter actor id:");
		String role2Role = Console.getString("Enter role: ");
		
		role2.setId(role2Id);
		role2.setMovieID(role2MovieID);
		role2.setActorID(role2ActorID);
		role2.setRole(role2Role);
		
		System.out.println(role2.toString());
		
		System.out.println("Now lets complete the last one of the credits.\n ");
		
		Credit role3 = new Credit();
		
		int role3Id = Console.getInt("Enter role id: ");
		int role3MovieID = Console.getInt("Enter movie id: ");
		int role3ActorID = Console.getInt("Enter actor id:");
		String role3Role = Console.getString("Enter role: ");
		
		role3.setId(role3Id);
		role3.setMovieID(role3MovieID);
		role3.setActorID(role3ActorID);
		role3.setRole(role3Role);
		
		System.out.println(role3.toString());
		
	}

}
