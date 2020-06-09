package client;

import Properties.DummyRestApiUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.postEmployeesApiModel.PostEmployeeDataRoot;
import model.getEmployeesApiModel.GetEmployeesDataRoot;
import model.updateEmployeeApiModel.UpdateEmployeeDataRoot;
import org.testng.Reporter;

import static Service.EmployeeApiService.*;

public class EmployeeClient {


	public GetEmployeesDataRoot getEmployeesDetails() {
		String url = DummyRestApiUrl.GetEmployees_URL;
		Response response = getEmployeesRequest(url);
		GetEmployeesDataRoot employee;
		int statusCode = response.getStatusCode();
		String getEmployeesApiResponse = response.getBody().asString();
		Gson gson = new Gson();
		if (statusCode == 200) {
			Reporter.log("Api Status is " + statusCode, true);
			Reporter.log("Post Employee data api response is " +getEmployeesApiResponse,true);
			employee = gson.fromJson(getEmployeesApiResponse, GetEmployeesDataRoot.class);
		} else {
			Reporter.log("Get Employees details api is failed " + statusCode, true);
			Reporter.log("Failed Get Employees api response is " + getEmployeesApiResponse, true);
			employee = gson.fromJson(getEmployeesApiResponse, GetEmployeesDataRoot.class);
		}
		return employee;
	}

	public PostEmployeeDataRoot postEmployeeDetails(String emp_name, String emp_age, String emp_salary) {
		String url = DummyRestApiUrl.PostEmployeeData_URL;
		Response response = postEmployeeData(url, emp_name, emp_age, emp_salary);
		PostEmployeeDataRoot employee;
		int statusCode = response.getStatusCode();
		Gson gson = new Gson();
		String postApiResponse = response.getBody().asString();
		if (statusCode == 200) {
			Reporter.log("Api Status is " + statusCode, true);
			Reporter.log("Post Employee data api response is " +postApiResponse,true);
			employee = gson.fromJson(postApiResponse, PostEmployeeDataRoot.class);
		} else {
			Reporter.log("Post Employees details api is failed " + statusCode, true);
			Reporter.log("Failed Post Employee date api response is " + postApiResponse, true);
			employee = gson.fromJson(postApiResponse, PostEmployeeDataRoot.class);
		}
		return employee;
	}

	public UpdateEmployeeDataRoot updateEmployeeDetails(String emp_name, String emp_age, String emp_salary,String emp_Id)
	{
		String url = DummyRestApiUrl.UpdateEmployeeData_URL + emp_Id;
		Reporter.log("Update Api URL "+url,true);
		Response response = putEmployeeData(url, emp_name, emp_age, emp_salary);
		UpdateEmployeeDataRoot employee;
		int statusCode = response.getStatusCode();
		Gson gson = new Gson();
		String updateApiResponse = response.getBody().asString();
		if (statusCode == 200) {
			Reporter.log("Api Status is " + statusCode, true);
			Reporter.log("Update Employee data api response is " +updateApiResponse,true);
			employee = gson.fromJson(updateApiResponse, UpdateEmployeeDataRoot.class);
		} else {
			Reporter.log("Update Employees details api is failed " + statusCode, true);
			Reporter.log("Failed Post Employee date api response is " + updateApiResponse, true);
			employee = gson.fromJson(updateApiResponse, UpdateEmployeeDataRoot.class);
		}
		return employee;
	}
}
