package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import Model.MySQLConnectionPool;

public class ServerCore extends Thread{
	private int port;
	private boolean stop = false;
	private ServerSocket ss;
	private LoggerWriter logger;
	public static MySQLConnectionPool pool;
	
	public ServerCore(int port) throws IOException {
		this.port = port;
		this.logger = new LoggerWriter();
		this.logger.setMessageLog("Server started...");
		pool = new MySQLConnectionPool();
		this.start();
	}
	
	public void run() {
		try(ServerSocket ss = new ServerSocket(port)){
			ss.setSoTimeout(1000);
			while(!stop){
				try{
					Socket s = ss.accept();
					this.logger.setMessageLog("New client connexion");
					new Thread(new HandleClient(s,this.logger, pool.acquireConnection())).start();
				}catch(SocketTimeoutException ex){
				}
			}
		} catch (IOException e) {
			
			this.logger.setErrorLog("ERROR : " + e);
		}
	}
	public synchronized void finish() {
		stop = true;
	}
	
	
	
}
