package model.postEmployeesApiModel;

public class PostEmployeeDataRoot {

	private String status;

	private PostEmployeeData data;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setData(PostEmployeeData data) {
		this.data = data;
	}

	public PostEmployeeData getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return "ClassPojo [data = " + data + ", status = " + status + "]";
	}

}
