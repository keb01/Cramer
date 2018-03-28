package Server;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Borne;
import Model.Zone;

public class InputManager {
	AppProtocol handler;
	InputStream in;
	
	public InputManager(InputStream in, AppProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException, JSONException {
		String json;
		String line = null;
		ObjectMapper mapper = new ObjectMapper();
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			
			while ((line = is.readLine()) != null) {
				System.out.println("CLIENT ASKING : "+line);
				InputQuery query = mapper.readValue(line, InputQuery.class);
				System.out.println("not ok");
				
                switch (query.getQueryType()) {
				case "LIST":
					switch (query.getTable()) {
					case "ZONE":
						handler.askListZones();
						break;
					case "BORNE":
						handler.askListBornes();
						break;
					default:
						break;
					}
					
					break;
				case "FIND":
					switch (query.getTable()) {
					case "ZONE":
						handler.askZone(Long.parseLong(query.getParam()));
						break;
					case "BORNE":
						handler.askBorne(Long.parseLong(query.getParam()));
						break;
					default:
						break;
					}
					
					break;	
				case "DELETE":
					
					switch (query.getTable()) {
					case "ZONE":
						handler.delZone(Long.parseLong(query.getParam()));
						break;
					case "BORNE":
						handler.delBorne(Long.parseLong(query.getParam()));
						break;
					default:
						break;
					}
					
					break;
				case "INSERT":
					
					switch (query.getTable()) {
					case "ZONE":
						handler.createZone(Long.parseLong(query.getParam()));
						break;
					case "BORNE":
						handler.createBorne(Long.parseLong(query.getParam()));
						break;
					default:
						break;
					}
					
					break;
				case "UPDATE":
					
					switch (query.getTable()) {
					case "ZONE":
						handler.updateZone(Long.parseLong(query.getParam()));
						break;
					case "BORNE":
						
						JSONObject param = new JSONObject(query.getParam());
						Borne borne = new Borne(param.getInt("id"),new Zone(param.getInt("idZone"), "", "", 0));
						// update to updateBorne(Borne borne)
						handler.updateBorne(borne);
						break;
					default:
						break;
					}
					
					break;
				default:
					break;
				}

			}
		}
	}
}
