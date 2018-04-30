package server.serverApp;

import java.io.IOException;


public class ServerMain {

    public static void main(String[] args) {
    	    	
        try {
            ServerCore server = new ServerCore(5000);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
