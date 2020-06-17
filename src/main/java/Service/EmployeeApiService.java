package Service;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class EmployeeApiService {

	 private static  Response response;

	public static Response getRequest(String url)
	{
		response = given().contentType("application/json").when().log().all().
				get(url).then().statusCode(200).extract().response();
		return response;
	}

	public static Response postRequest(String url, String request)
	{
		response = given().contentType("application/json").body(request).when().log().all().
				post(url).then().statusCode(200).extract().response();
		return  response;
	}

	public static Response putRequest(String url, String request)
	{
		response = given().when().contentType("application/json").body(request).when().log().all()
				.put(url).then().statusCode(200).extract().response();
		return  response;
	}
}
