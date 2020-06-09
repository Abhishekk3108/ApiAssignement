import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SampleGetRequest {


	@Test
	public void sampleGetRequest() {
		Response response = given().
				queryParam("page", "1")
				.get("https://reqres.in/api/users");
		ObjectMapper oMapper = new ObjectMapper();
		System.out.println("Api status is " + response.getStatusCode());
		if (response.getStatusCode() == 200) {
			response.getBody().print();
			Map<String, Object> dataMap = oMapper.convertValue(response.jsonPath().getList("data").get(0), Map.class);
			System.out.println("**************" + dataMap);
			for (Map.Entry dataEle : dataMap.entrySet()) {
				System.out.println(dataEle.getKey() + " :: " + dataEle.getValue());
			}
			System.out.println("Api call for get user is successful and data matches with exepected results");
		}
	}



	@Test
	public static  void charCount()
	{
		String inp = "Java J2ee";
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		String s = inp.replaceAll("\\s+", "");
		char[] charArray = s.toCharArray();
		for (char char1:charArray) {
          if (map.containsKey(char1))
		  {
		  	map.remove(char1);
		  }

		}
		System.out.println(inp+":"+map);
	}

	@Test
	public void countChar()
	{
		String inp = "A@b!h#i$s%hˆe&k*K(r)u?t<h>i";
		String res= "";
		for (int i =0 ; i< inp.length(); i++)
		{
			if (inp.charAt(i)>64 && inp.charAt(i)<=122)
			{
				res	= res+inp.charAt(i);
			}
		}
		System.out.println(res);

	}

}

