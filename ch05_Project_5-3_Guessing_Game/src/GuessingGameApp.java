import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++ ");

		System.out.println("Im thinking of a number from 1 to 100");
		System.out.println("Try to guess it");

		Scanner sc = new Scanner(System.in);
		String choice = "";

		do {
			int randomNum = (int) (Math.random() * 100) + 1;
			boolean isCorrect = false;

			int attempts = 0;
			while (!isCorrect) {

				int guess = getIntWithinRange(sc, "Guess a number: ", 1, 100);
				if ((randomNum + 10) < guess) {
					System.out.println("Way too high");
					attempts++;
					continue;
				}
				else if (randomNum < guess) {
					System.out.println("Too high: ");
					attempts++;
					continue;
				}
				else if ((randomNum - 10) > guess) {
					System.out.println("Way too low: ");
					attempts++;
					continue;
				}
				else if (randomNum > guess ) {
					System.out.println("Too low: ");
					attempts++;
					continue;
				}else

				isCorrect = true;

			}

			System.out.println("Congrats, you got it right , and it only took you " + attempts + " tries");
			if (attempts > 7) {
				System.out.println("What tookyou so long?");
			} else if (attempts > 3) {
				System.out.println("Not bad!");
			} else {
				System.out.println("Youre a number guessing wizard!");
			}

			System.out.println("Continue? (y/n): ");
			choice = sc.next();

		} while (choice.equalsIgnoreCase("y"));

		System.out.println("Goodbye");
		sc.close();

	}

	private static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		boolean isValid = false;
		int input = 0;

		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				input = sc.nextInt();
			} else {
				System.out.println("I said give me an int");
				sc.nextLine();
				continue;
			}
			if (input < min) {

				System.out.println("Needs to be at least " + min);
				sc.nextLine();
				continue;

			} else if (input > max) {

				System.out.println("needs to be" + max + "or less");
				sc.nextLine();
				continue;
			} else {
				sc.nextLine();
				isValid = true;
			}

		}

		return input;

	}
}
