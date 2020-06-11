package client;

import Properties.DummyRestApiUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.postEmployeesApiModel.EmployeeDataReqBuilder;
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
		String getEmployeesApiResponse = response.getBody().asString();
		Gson gson = new Gson();
		if (response.getStatusCode() == 200) {
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Post Employee data api response is " +getEmployeesApiResponse,true);
			employee = gson.fromJson(getEmployeesApiResponse, GetEmployeesDataRoot.class);
		} else {
			Reporter.log("Get Employees details api is failed " + response.getStatusCode(), true);
			Reporter.log("Failed Get Employees api response is " + getEmployeesApiResponse, true);
			employee = gson.fromJson(getEmployeesApiResponse, GetEmployeesDataRoot.class);
		}
		return employee;
	}

	public PostEmployeeDataRoot postEmployeeDetails(String emp_name, String emp_age, String emp_salary) {
		Gson gson = new Gson();
		String url = DummyRestApiUrl.PostEmployeeData_URL;
		EmployeeDataReqBuilder reqBody = new EmployeeDataReqBuilder();
		String request = gson.toJson(reqBody.employeeDetails(emp_name, emp_age, emp_salary).build());
		Response response = postEmployeeData(url,request);
		PostEmployeeDataRoot employee;
		String postApiResponse = response.getBody().asString();
		if (response.getStatusCode()== 200) {
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Post Employee data api response is " +postApiResponse,true);
			employee = gson.fromJson(postApiResponse, PostEmployeeDataRoot.class);
		} else {
			Reporter.log("Post Employees details api is failed " + response.statusCode(), true);
			Reporter.log("Failed Post Employee date api response is " + postApiResponse, true);
			employee = gson.fromJson(postApiResponse, PostEmployeeDataRoot.class);
		}
		return employee;
	}

	public UpdateEmployeeDataRoot updateEmployeeDetails(String emp_name, String emp_age, String emp_salary,String emp_Id)
	{
		Gson gson = new Gson();
		String url = DummyRestApiUrl.UpdateEmployeeData_URL + emp_Id;
		Reporter.log("Update Api URL "+url,true);
		EmployeeDataReqBuilder reqBody = new EmployeeDataReqBuilder();
		String request = gson.toJson(reqBody.employeeDetails(emp_name, emp_age, emp_salary).build());
		Response response = putEmployeeData(url, request);
		UpdateEmployeeDataRoot employee;
		String updateApiResponse = response.getBody().asString();
		if (response.getStatusCode() == 200) {
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Update Employee data api response is " +updateApiResponse,true);
			employee = gson.fromJson(updateApiResponse, UpdateEmployeeDataRoot.class);
		} else {
			Reporter.log("Update Employees details api is failed " + response.getStatusCode(), true);
			Reporter.log("Failed Post Employee date api response is " + updateApiResponse, true);
			employee = gson.fromJson(updateApiResponse, UpdateEmployeeDataRoot.class);
		}
		return employee;
	}
}
