package tiy.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringAppApplicationTests {

	@Test
	public void contextLoads() {
	}

	//Put in separate test file (WebChatClientTest)
//	@Test
//	public void testSendMessage() throws Exception {
//		String testMessage = "Message--hello2-";
//		WebChatClient myWebChatClient = new WebChatClient();
//
//		String serverResponse = myWebChatClient.sendMessage(testMessage);
//
//		System.out.println(serverResponse);
//		//Make sure you get a response
//		assertNotNull(serverResponse);
//		//Make sure the message from the server is what you think it should be
////        assertEquals();
//	}

}
