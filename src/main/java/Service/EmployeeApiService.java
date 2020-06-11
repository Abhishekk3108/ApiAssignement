package Service;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class EmployeeApiService {

	static  Response response;

	public static Response getEmployeesRequest(String url)
	{
		response = given().when().get(url).then().statusCode(200).extract().response();
		return response;
	}

	public static Response postEmployeeData(String url,String request)
	{
		response = given().contentType("application/json").body(request).when().log().all().
				post(url).then().statusCode(200).extract().response();
		return  response;
	}

	public static Response putEmployeeData(String url,String request)
	{
		response = given().when().contentType("application/json").body(request).when().log().all()
				.put(url).then().statusCode(200).extract().response();
		return  response;
	}
}
