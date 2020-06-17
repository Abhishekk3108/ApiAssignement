package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class ApiDataSet {

	@DataProvider(name = "postEmployeeApiData")
	public static Object[][] userSearch() {
		return new Object[][]{
				{"John","20","38000"},
		};
	}

	@DataProvider(name = "getEmployeeData")
	public static Object[][] userData() {
		return  new  Object[][]{
				{"7","Herrod Chandler","137500","59"}
	};
}}
