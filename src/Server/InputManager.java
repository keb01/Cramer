package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.jackson.map.ObjectMapper;

public class InputManager {
	AppProtocol handler;
	InputStream in;
	
	public InputManager(InputStream in, AppProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException {
		String json;
		String line = null;
		ObjectMapper mapper = new ObjectMapper();
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			
			while ((line = is.readLine()) != null) {
				System.out.println(line);
				InputQuery query = mapper.readValue(line, InputQuery.class);
				System.out.println(query.getQueryType());
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
					
					break;	
				case "DELETE":
					
					break;
				case "INSERT":
					
					break;
				case "UPDATE":
					
					break;
				default:
					break;
				}

			}
		}
	}
}
