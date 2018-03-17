package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientTest {

    public static void main(String[] args) {
        try {
            Socket s  = new Socket("localhost", 5000);
            PrintStream printStream = new PrintStream(s.getOutputStream());
            printStream.print("toto\n");
            try (BufferedReader is = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                while (true) {
                    String line = is.readLine();
                    System.out.println(line);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
