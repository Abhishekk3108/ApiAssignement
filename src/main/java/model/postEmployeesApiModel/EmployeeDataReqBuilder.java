package model.postEmployeesApiModel;

public class EmployeeDataReqBuilder {

	EmployeeDataReq req = new EmployeeDataReq();

	public EmployeeDataReqBuilder employeeDetails(String name, String  age, String salary)
	{
		req.setName(name);
		req.setAge(age);
		req.setSalary(salary);
		return this;
	}

	public  EmployeeDataReq build()
	{
		return req;
	}

}
