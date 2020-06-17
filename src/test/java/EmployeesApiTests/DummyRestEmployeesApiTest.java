package EmployeesApiTests;

import client.EmployeeClient;
import model.postEmployeesApiModel.PostEmployeeDataRoot;
import model.getEmployeesApiModel.GetEmployeesDataRoot;
import model.updateEmployeeApiModel.Data;
import model.updateEmployeeApiModel.EmployeeData;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import dataProviders.ApiDataSet;

public class DummyRestEmployeesApiTest extends EmployeeClient {

	private  String employeeId = "7";

	@Test(priority = 1)
	public void validateGetAllEmployeesApi() {
		EmployeeClient client = new EmployeeClient();
		GetEmployeesDataRoot employeesResponse = client.getAllEmployeesDetails();
		Assert.assertEquals(client.getHttpStatusCode(),200,"");
		Assert.assertEquals(employeesResponse.getStatus(), "success",
				"Get employees details api status response is " + employeesResponse.getStatus());
		employeeId = employeesResponse.getData().get(2).getId();
		Reporter.log("Get user api response data ", true);
		Reporter.log("Get All employee response time is : "+ client.getResponseTime());
		for (int i = 0; i < employeesResponse.getData().size(); i++) {
			Reporter.log(employeesResponse.getData().get(i).getEmployee_name(), true);
			Reporter.log(employeesResponse.getData().get(i).getEmployee_age(), true);
			Reporter.log(employeesResponse.getData().get(i).getEmployee_salary(), true);
			Reporter.log(employeesResponse.getData().get(i).getId(), true);
		}
	}

	@Test(dataProvider = "postEmployeeApiData",dataProviderClass = ApiDataSet.class,priority = 2)
	public  void validatePostEmployeeApi(String empName,String empAge,String empSalary)
	{
		EmployeeClient client = new EmployeeClient();
		PostEmployeeDataRoot employeeDetails = client.postEmployeeDetails(empName, empAge, empSalary);
		Assert.assertEquals(employeeDetails.getStatus(), "success",
				"Post employee api status response is  " + employeeDetails.getStatus());
		Reporter.log("Post user api response is" + employeeDetails, true);
		Assert.assertEquals(empName,employeeDetails.getData().getName(),
				"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,employeeDetails.getData().getAge(),
				"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,employeeDetails.getData().getSalary(),
				"Expected and actual employee salaries are not matching");
		Reporter.log("Post employee api test is pass",true);
	}

	@Test(dataProvider = "postEmployeeApiData",dataProviderClass = ApiDataSet.class, priority = 3)
	public  void validateUpdateEmployeeApi(String empName,String empAge,String empSalary)
	{
		EmployeeClient client = new EmployeeClient();
		Data updateEmployeeDetails = client.updateEmployeeDetails(empName, empAge, empSalary,employeeId);
			Assert.assertEquals(updateEmployeeDetails.getStatus(), "success",
					"Post employee api status response is  " + updateEmployeeDetails.getStatus());
			Reporter.log("Post user api response is" + updateEmployeeDetails, true);
			Assert.assertEquals(empName,updateEmployeeDetails.getData().getEmployee_name(),
					"Expected and actual employee names are not matching");
			Assert.assertEquals(empAge,updateEmployeeDetails.getData().getEmployee_age(),
					"Expected and actual employee ages are not matching");
			Assert.assertEquals(empSalary,updateEmployeeDetails.getData().getEmployee_salary(),
					"Expected and actual employee salaries are not matching");
	}

	@Test(dataProvider =  "getEmployeeData",dataProviderClass = ApiDataSet.class, priority = 4)
	public  void validateGetEmployeeApi(String empName,String empAge,String empSalary,String empId)
	{
		EmployeeClient client = new EmployeeClient();
		Data getEmployeeDetail = client.getEmployeeDetails(employeeId);
		Assert.assertEquals(getEmployeeDetail.getStatus(), "success",
				"Get employee api status response is  " + getEmployeeDetail.getStatus());
		Reporter.log("Get user api response is" + getEmployeeDetail, true);
		Reporter.log("Get user api response is" + getEmployeeDetail, true);
		Assert.assertEquals(empId,getEmployeeDetail.getData().getId(),
				"Expected and actual employee names are not matching");
		Assert.assertEquals(empName,getEmployeeDetail.getData().getEmployee_name(),
				"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,getEmployeeDetail.getData().getEmployee_age(),
				"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,getEmployeeDetail.getData().getEmployee_salary(),
				"Expected and actual employee salaries are not matching");
	}
}