package EmployeesApiTests;

import client.EmployeeClient;
import com.relevantcodes.extentreports.ExtentReports;
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
		Reporter.log("Get All employee response time is : "+ client.getResponseTime());
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
		PostEmployeeDataRoot employeeDetails = client.postEmployeeDetails(empName, empAge, empSalary);
		Assert.assertEquals(employeeDetails.getStatus(), "success",
				"Post employee api status response is  " + employeeDetails.getStatus());
		Reporter.log("Post user api response is" + employeeDetails, true);
		Assert.assertEquals(empName,employeeDetails.getData().getName(),"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,employeeDetails.getData().getAge(),"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,employeeDetails.getData().getSalary(),"Expected and actual employee salaries are not matching");
		Reporter.log("Post employee api test is pass",true);
	}

	@Test(dataProvider = "postEmployeeApiData",dataProviderClass = ApiDataSet.class)
	public  void validateUpdateEmployeeApi(String empName,String empAge,String empSalary)
	{
		EmployeeClient client = new EmployeeClient();
		UpdateEmployeeDataRoot updateEmployeeDetails = client.updateEmployeeDetails(empName, empAge, empSalary,employeeId);
		Assert.assertEquals(updateEmployeeDetails.getStatus(), "success",
				"Post employee api status response is  " + updateEmployeeDetails.getStatus());
		Reporter.log("Post user api response is" + updateEmployeeDetails, true);
		Assert.assertEquals(empName,updateEmployeeDetails.getData().getEmployee_name(),"Expected and actual employee names are not matching");
		Assert.assertEquals(empAge,updateEmployeeDetails.getData().getEmployee_age(),"Expected and actual employee ages are not matching");
		Assert.assertEquals(empSalary,updateEmployeeDetails.getData().getEmployee_salary(),"Expected and actual employee salaries are not matching");
	}



}