package rxdemo.endpoints;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class HelloWorldEndpoints
{
	public static void main(String[] args) {

		get("/hello", (req, res) -> "Hello World");

		post("/rx", (request, response) -> {
			System.out.println(request.body());
			return "{}";
		});


		before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header( "Access-Control-Allow-Headers", "Content-Type");
		});

		options("/rx", (Request request, Response response) -> {
			response.header( "Access-Control-Allow-Headers", "Content-Type");
			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Request-Method", accessControlRequestHeaders);
			}

			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if(accessControlRequestMethod != null){
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}
			return "OK";
		});

	}

}
