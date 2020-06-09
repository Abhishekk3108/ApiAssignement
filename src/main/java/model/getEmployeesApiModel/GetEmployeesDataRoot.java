package model.getEmployeesApiModel;

import java.util.List;

public class GetEmployeesDataRoot {


	private String status;
	private List<GetEmployeeData> data;

	public List<GetEmployeeData> getData() {
		return data;
	}

	public void setData(List<GetEmployeeData> data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClassPojo [data = " + data + ", status = " + status + "]";
	}

}
