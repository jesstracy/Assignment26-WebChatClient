package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jessicatracy on 9/12/16.
 */

// Assignment14 has a server that you can connect to that has capability to print history!!
// Note: History capability not pushed to github
public class WebChatClient {
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    HashMap<String, String> responsesHashMap = new HashMap<>();

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
//            System.out.println("\tIN SENDHISTORYMESSAGE");
            createClientSocket();

            out.println("history");
            serverResponse = in.readLine();
            while (!(serverResponse.equals("HISTORY::END."))) {
//                System.out.println("\tGetting a line from server... " + serverResponse);
                responses.add(serverResponse);
                serverResponse = in.readLine();
            }
//            System.out.println(responses.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return responses;

    }

//    public HashMap<String, String> sendHistoryMessageNew() {
//        String serverResponse = null;
//
//        try {
////            System.out.println("\tIN SENDHISTORYMESSAGE");
//            createClientSocket();
//
//            out.println("history");
//            serverResponse = in.readLine();
//            int counter = 1;
//            while (!(serverResponse.equals("HISTORY::END."))) {
////                System.out.println("\tGetting a line from server... " + serverResponse);
//                System.out.println("Putting response in hashmap: " + serverResponse);
//                responsesHashMap.put("name" + counter, serverResponse);
//                serverResponse = in.readLine();
//                counter++;
//            }
//            System.out.println("!!!!!! HashMap in client class: " + responsesHashMap.toString());
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        return responsesHashMap;
//
//    }

    public void createClientSocket() throws IOException {
        clientSocket = new Socket("localhost", 8005);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
}
