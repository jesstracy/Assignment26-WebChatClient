package tiy.webapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

import static org.junit.Assert.*;

/**
 * Created by jessicatracy on 9/12/16.
 */
public class WebChatClientTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        String testMessage = "Message--hello2-";
        WebChatClient myWebChatClient = new WebChatClient();

        String serverResponse = myWebChatClient.sendMessage(testMessage);

//        System.out.println(serverResponse);
        //Make sure you get a response
        assertNotNull(serverResponse);
        //Make sure the message from the server is what you think it should be
        //What I'm getting back from tomcat server: HTTP/1.1 400
        assertEquals("Echo: " + testMessage, serverResponse);
    }

}