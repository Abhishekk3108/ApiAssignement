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
}
