package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputManager {
	AppProtocol handler;
	InputStream in;
	
	public InputManager(InputStream in, AppProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException {
		String json;
		boolean stop = false;
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			while (!stop) {
				String line = is.readLine();
				System.out.println("lecture"+line);

                    System.out.println("requette listeMag");
					handler.askListMagasin();
					handler.askListBornes();

				
				//LECTURE DU JSON DE QUERIES
			}
		}
	}
}
