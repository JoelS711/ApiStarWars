package swapi;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class SearchMovie {

	public Movie consultMovie(int numberOfMovie) {
		URI url = URI.create("https://swapi.py4e.com/api/films/"+numberOfMovie+"/");
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(url).build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), Movie.class);
		} catch (Exception e) {
			throw new RuntimeException("I can't find that movie");
		}
	}
}
