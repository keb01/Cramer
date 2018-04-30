package pdstest;


import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import model.Zone;


public class TestJSON  {

	public static void main(String[] args) throws IOException, JSONException{
		// TODO Auto-generated method stub
		
		
		ObjectMapper mapper = new ObjectMapper();
		Client user = new Client("un","deux","trois","quatre","cinq","six","sept");

		//Object to JSON in file
		mapper.writeValue(new File("client.json"), user);
		
		String oui = "{\"nom\":\"toto\",\"param\":{\"adresse\":\"trois\",\"email\":4}}";
		
		/* 
		 * { "nom"   : "toto",
		 * 	 "param" : {
		 * 				 "adresse" : "trois",
		 * 				 "email"   : "quatre"
		 * 				}
		 * }
		 * 
		 * 
		 * 
		 */
		
		
		JSONObject param = new JSONObject(oui) ;
		JSONObject param2 = param.getJSONObject("param") ;
		int ok = param2.getInt("email");
		System.out.println(param);
		System.out.println(param2);
		System.out.println(ok);
		
		Client user1 = mapper.readValue(new File("client.json"),Client.class);
		System.out.println(user1.nom);
		
		//System.out.println(zone1.nom);
	}
	
	
	
}
