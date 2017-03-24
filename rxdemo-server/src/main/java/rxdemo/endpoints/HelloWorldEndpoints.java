package rxdemo.endpoints;

import static spark.Spark.*;

public class HelloWorldEndpoints
{
	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}
}
