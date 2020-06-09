package Properties;

public class DummyRestApiUrl {
	private static final PropertiesReader propertiesReader = new PropertiesReader();
	public static final String HOST = propertiesReader.getHostUrl();
	public static final String GetEmployees_URL = String.format("%s/api/v1/employees", HOST);
	public static final String PostEmployeeData_URL = String.format("%s/api/v1/create", HOST);
	public static final String UpdateEmployeeData_URL = String.format("%s/api/v1/update/",HOST);
}
