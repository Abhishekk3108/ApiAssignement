package model.postEmployeesApiModel;

public class EmployeeDataReqBody {
	private String name;

	private String salary;

	private String age;

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSalary(String salary){
		this.salary = salary;
	}
	public String getSalary(){ return this.salary; }
	public void setAge(String age){ this.age = age; }
	public String getAge(){
		return this.age;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [name = "+name+", salary = "+salary+", age = "+age+"]";
	}

}
