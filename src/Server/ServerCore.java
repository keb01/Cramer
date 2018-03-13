package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerCore extends Thread{
	private int port;
	private boolean stop = false;
	private ServerSocket ss;
	// private logger Terence
	
	public ServerCore(int port) throws IOException {
		this.port = port;
		//logger ("Server started...")
		this.start();
	}
	
	public void run() {
		try(ServerSocket ss = new ServerSocket(port)){
			ss.setSoTimeout(1000);
			while(!stop){
				try{
					Socket s = ss.accept();
					//logger (nouveau client)
					new Thread(new HandleClient(s)).start();
				}catch(SocketTimeoutException ex){
				}
			}
		} catch (IOException e) {
			System.out.println("Impossible d'utiliser le port " + port);
			//Logger.getLogger(ServerCore.class.getName()).log(Level.SEVERE,null, e);
		}
	}
	public synchronized void finish() {
		stop = true;
	}
	
	
	
}
