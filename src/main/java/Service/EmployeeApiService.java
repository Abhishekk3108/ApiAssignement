package Service;

import io.restassured.response.Response;
import model.postEmployeesApiModel.EmployeeDataReqBody;
import static io.restassured.RestAssured.given;


public class EmployeeApiService {

	public static Response getEmployeesRequest(String url) {
		Response response = given().when().get(url).then().statusCode(200).extract().response();
		return response;
	}

	public static Response postEmployeeData(String url,String name,String age,String salary)
	{
		EmployeeDataReqBody employee = new EmployeeDataReqBody();
		employee.setName(name);
		employee.setAge(age);
		employee.setSalary(salary);
		Response response = given().contentType("application/json").body(employee).when().log().all().
				post(url).then().statusCode(200).extract().response();
		return  response;
	}

	public static Response putEmployeeData(String url,String name,String age,String salary)
	{
		EmployeeDataReqBody employee = new EmployeeDataReqBody();
		employee.setName(name);
		employee.setAge(age);
		employee.setSalary(salary);
		Response response = given()
				.when().contentType("application/json").body(employee).when().log().all()
				.put(url).then().statusCode(200).extract().response();
		return  response;

	}
}
