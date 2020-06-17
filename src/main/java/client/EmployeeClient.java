package client;

import Properties.DummyRestApiUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import model.postEmployeesApiModel.EmployeeDataReqBuilder;
import model.postEmployeesApiModel.PostEmployeeDataRoot;
import model.getEmployeesApiModel.GetEmployeesDataRoot;
import model.updateEmployeeApiModel.Data;
import model.updateEmployeeApiModel.EmployeeData;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import static Service.EmployeeApiService.*;

public class EmployeeClient
{
	private Response response;
	private Gson gson = new Gson();
	private long responseTime;


	public long getResponseTime() { return responseTime; }

	private void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}


	public GetEmployeesDataRoot getAllEmployeesDetails() {
		response = getRequest(DummyRestApiUrl.GetEmployees_URL);
		setResponseTime(response.getTimeIn(TimeUnit.MILLISECONDS));
		GetEmployeesDataRoot employee;
		String getEmployeesApiResponse = response.getBody().asString();
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Post Employee data api response is " +getEmployeesApiResponse,true);
			employee = gson.fromJson(getEmployeesApiResponse, GetEmployeesDataRoot.class);
		return employee;
	}

	public PostEmployeeDataRoot  postEmployeeDetails(String emp_name, String emp_age, String emp_salary) {
		EmployeeDataReqBuilder reqBody = new EmployeeDataReqBuilder();
		String request = gson.toJson(reqBody.employeeDetails(emp_name, emp_age, emp_salary).build());
		response = postRequest(DummyRestApiUrl.PostEmployeeData_URL,request);
		PostEmployeeDataRoot employee;
		String postApiResponse = response.getBody().asString();
		setResponseTime(response.getTimeIn(TimeUnit.MILLISECONDS));
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Post Employee data api response is " +postApiResponse,true);
			employee = gson.fromJson(postApiResponse, PostEmployeeDataRoot.class);
		return employee;
	}

	public Data updateEmployeeDetails(String emp_name, String emp_age, String emp_salary, String emp_Id)
	{
		String url = DummyRestApiUrl.UpdateEmployeeData_URL + emp_Id;
		Reporter.log("Update Api URL "+url,true);
		EmployeeDataReqBuilder reqBody = new EmployeeDataReqBuilder();
		String request = gson.toJson(reqBody.employeeDetails(emp_name, emp_age, emp_salary).build());
		response = putRequest(url, request);
		setResponseTime(response.getTimeIn(TimeUnit.MILLISECONDS));
		Data employee;
		String updateApiResponse = response.getBody().asString();
			Reporter.log("Api Status is " + response.getStatusCode(), true);
			Reporter.log("Update Employee data api response is " +updateApiResponse,true);
			employee = gson.fromJson(updateApiResponse, Data.class);
		return employee;
	}

	public Data getEmployeeDetails(String empId)
	{
		String url = DummyRestApiUrl.GetEmployee_URL + empId;
		Reporter.log("Get employee Api URL " + url, true);
		response  = getRequest(url);
		setResponseTime(response.getTimeIn(TimeUnit.MILLISECONDS));
		Data employee;
		String getEmployeeApiResponse = response.getBody().asString();
		Reporter.log("Api Status is " + response.getStatusCode(), true);
		Reporter.log("Post Employee data api response is " +getEmployeeApiResponse,true);
		employee = gson.fromJson(getEmployeeApiResponse, Data.class);
		return employee;
	}


	public int getHttpStatusCode()
	{
		return response.getStatusCode();
	}
}
