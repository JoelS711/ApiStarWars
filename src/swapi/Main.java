package swapi;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		SearchMovie consult = new SearchMovie();
		System.out.println("Star Wars movie number you want to consult: ");

		try {
			var numberMovie = Integer.valueOf(keyboard.nextLine());
			Movie movie = consult.consultMovie(numberMovie);
			System.out.println(movie);
			FileGenerator fileGenerator = new FileGenerator();
			fileGenerator.saveJson(movie);
		} catch (NumberFormatException e) {
			System.out.println("Number not found " + e.getMessage());
		} catch (RuntimeException | IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Finishing the app");
		}
		keyboard.close();
	}

}
