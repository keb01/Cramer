package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerCore extends Thread{
	private int port;
	private boolean stop = false;
	private ServerSocket ss;
	private LoggerWriter logger;
	
	public ServerCore(int port) throws IOException {
		this.port = port;
		this.logger.setMessageLog("Server started...");
		this.start();
	}
	
	public void run() {
		try(ServerSocket ss = new ServerSocket(port)){
			ss.setSoTimeout(1000);
			while(!stop){
				try{
					Socket s = ss.accept();
					this.logger.setMessageLog("Un client s'est connecté");
					new Thread(new HandleClient(s,this.logger)).start();
				}catch(SocketTimeoutException ex){
				}
			}
		} catch (IOException e) {
			System.out.println("Impossible d'utiliser le port " + port);
			this.logger.setErrorLog("Erreur : " + e);
		}
	}
	public synchronized void finish() {
		stop = true;
	}
	
	
	
}
