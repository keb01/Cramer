package Server;

import java.io.IOException;
import java.net.Socket;

public class HandleClient implements AppProtocol{
	private final Socket s;
	private InputManager in;
	private OutputManager out;
	private boolean stop = false;
	// private logger Terence
	
	
	public HandleClient(Socket s /*, logger Terence*/) throws IOException {
		this.s = s;
		//this.logger = logger;
	}
	
	public void run() {
		try (Socket s1 = s) {
			out = new OutputManager(s1.getOutputStream());
			in = new InputManager(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException ex) {
			if (!stop) {
				finish();
			}
		}
	}
	
	public synchronized void finish(){
		if (!stop) {
			stop = true;
			try {
				s.close();
			} catch (IOException ex) { ex.printStackTrace(); }
			
			// logger Terence : client deconnecte
		}
	}
	
	
	// IMPLEMENT METHODES DU PROTOCOL EN UTILISANT NOTRE 'OUT'
}
