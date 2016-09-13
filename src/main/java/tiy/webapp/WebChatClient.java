package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by jessicatracy on 9/12/16.
 */
public class WebChatClient {
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public String sendMessage(String message) {
        String serverResponse = null;
        try {
            createClientSocket();

            out.println(message);
            serverResponse = in.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return serverResponse;

//        return null;
    }

    public ArrayList<String> sendHistoryMessage() {
        String serverResponse = null;
        ArrayList<String> responses = new ArrayList<String>();
        try {
            createClientSocket();

            out.println("history");

            while ((serverResponse = in.readLine()) != null) {
                responses.add(serverResponse);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return responses;

    }

    public void createClientSocket() throws IOException {
        clientSocket = new Socket("localhost", 8005);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
}
