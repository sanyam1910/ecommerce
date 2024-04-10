package Dataprovider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	
	public List<HashMap<String, String>> getJsonDatatohashmap() throws IOException
		{
			String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir"+"\\src\\test\\java\\Dataprovider\\PlaceOrder.json")),StandardCharsets.UTF_8);
			
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> Data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){
				});
			
		
	return Data;
	
					
		}
}
