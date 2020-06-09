package EmployeesApiTests;

import client.EmployeeClient;
import model.postEmployeesApiModel.PostEmployeeDataRoot;
import model.getEmployeesApiModel.GetEmployeesDataRoot;
import model.updateEmployeeApiModel.UpdateEmployeeDataRoot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import dataProviders.ApiDataSet;

public class DummyRestEmployeesApiTest extends EmployeeClient {

	String employeeId = "7";

	@Test
	public void validateGetEmployeesApi() {
		EmployeeClient client = new EmployeeClient();
		GetEmployeesDataRoot employeesResponse = client.getEmployeesDetails();
		Assert.assertEquals(employeesResponse.getStatus(), "success",
				"Get employees details api status response is " + employeesResponse.getStatus());
		employeeId = employeesResponse.getData().get(2).getId();
		Reporter.log("Get user api response data ", true);
		for (int i = 0; i < employeesResponse.getData().size(); i++) {
			Reporter.log(employeesResponse.getData().get(i).getEmployee_name(), true);
			Reporter.log(employeesResponse.getData().get(i).getEmployee_age(), true);
			Reporter.log(employeesResponse.getData().get(i).getEmployee_salary(), true);
			Reporter.log(employeesResponse.getData().get(i).getId(), true);
		}
	}

	@Test(dataProvider = "postEmployeeApiData",dataProviderClass = ApiDataSet.class)
	public  void validatePostEmployeeApi(String empName,String empAge,String empSalary)
	{
		EmployeeClient client = new EmployeeClient();
		PostEmployeeDataRoot data = client.postEmployeeDetails(empName, empAge, empSalary);
		Assert.assertEquals(data.getStatus(), "success",
				"Post employee api status response is  " + data.getStatus());
		Reporter.log("Post user api response is" + data, true);
		Assert.assertEquals(empName,data.getData().getName(),"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,data.getData().getAge(),"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,data.getData().getSalary(),"Expected and actual employee salaries are not matching");
	}

	@Test(dataProvider = "postEmployeeApiData",dataProviderClass = ApiDataSet.class)
	public  void validateUpdateEmployeeApi(String empName,String empAge,String empSalary)
	{
		EmployeeClient client = new EmployeeClient();
		UpdateEmployeeDataRoot data = client.updateEmployeeDetails(empName, empAge, empSalary,employeeId);
		Assert.assertEquals(data.getStatus(), "success",
				"Post employee api status response is  " + data.getStatus());
		Reporter.log("Post user api response is" + data, true);
		Assert.assertEquals(empName,data.getData().getEmployee_name(),"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,data.getData().getEmployee_age(),"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,data.getData().getEmployee_salary(),"Expected and actual employee salaries are not matching");
	}



}