package model.updateEmployeeApiModel;

public class UpdateEmployeeDataRoot {
	private UpdateEmployeeData data;

	private String status;

	public UpdateEmployeeData getData ()
	{
		return data;
	}

	public void setData (UpdateEmployeeData data)
	{
		this.data = data;
	}

	public String getStatus ()
	{
		return status;
	}

	public void setStatus (String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [data = "+data+", status = "+status+"]";
	}
}