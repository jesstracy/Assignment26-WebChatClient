package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jessicatracy on 9/12/16.
 */
public class WebChatClient {
    public String sendMessage(String message) {
        String serverResponse = null;
        try {
            Socket clientSocket = new Socket("localhost", 8005);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(message);
            serverResponse = in.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return serverResponse;

//        return null;
    }
}
