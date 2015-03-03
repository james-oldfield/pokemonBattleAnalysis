// Using the same library as main Processing sketch to take the pain out of HTTP requests
import http.requests.*;

public class Request {

	String uri;

	// holds the single instance of the class to prevent multiple hits to the API - static to allow it global scope
	private static Request instance = null;

	// The constructor is created as Private so that there cannot be any instantiations of the class other than the singleton.
	private Request() {
		// Hit the pokedex endpoint, returning a list of all data on the database as a reference point for further requests
		uri = "pokedex/1";
	}

	public static Request getInstance() {
		if (instance == null) {
			// Lazy instantiation - Only being created if it is needed and getInstance method is called
			instance = new Request();
		}

		// By now, the instance object will always be in the instantiation of the Request class via the Singleton pattern.
		return instance;
	}

	public String returnPokedexData() {
		GetRequest g = new GetRequest("http://pokeapi.co/api/v1/" + uri);
		g.send();

		// the getContent method innate to the http request library returns the content as a String, so needs to be converted to a JSONObject or HashMap later
		String pokedexData = g.getContent();

		// return the string containing the whole Pokedex data
		return pokedexData;
	}

}