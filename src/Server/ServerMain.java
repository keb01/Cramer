package Server;

import java.io.IOException;


public class ServerMain {

    public static void main(String[] args) {
    	    	
        try {
            ServerCore server = new ServerCore(5001);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
