package swapi;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileGenerator {

	public void saveJson(Movie movie) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter writing = new FileWriter(movie.title()+".json");
		writing.write(gson.toJson(movie));
		writing.close();
	}
}
