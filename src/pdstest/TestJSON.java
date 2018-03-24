package pdstest;


import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Model.Zone;


public class TestJSON  {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		ObjectMapper mapper = new ObjectMapper();
		Client user = new Client("un","deux","trois","quatre","cinq","six","sept");

		//Object to JSON in file
		mapper.writeValue(new File("client.json"), user);
		Client user1 = mapper.readValue(new File("client.json"),Client.class);
		System.out.println(user1.nom);
		
		Zone zone1 = mapper.readValue(new File("zone.json"),Zone.class);
		//System.out.println(zone1.nom);
	}
	
	
	
}
