package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputManager implements AppProtocol{
	PrintWriter ow;
	
	
	public OutputManager(OutputStream out) throws IOException {
		this.ow = new PrintWriter(out, true);
	}
	
	// IMPLEMENT METHODES DU PROTOCOL POUR ENVOI JSON AU CLIENT
	
}
