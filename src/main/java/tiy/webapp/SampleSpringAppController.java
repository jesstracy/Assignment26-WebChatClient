package tiy.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SampleSpringAppController {
    WebChatClient myWebChatClient;
    @RequestMapping(path = "/person-url", method = RequestMethod.GET)
    public String person(Model model, String name, String city, int age) {

        Person p = new Person(name, city, age);
        model.addAttribute("person-object", p);
        return "person-view";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    //Don't
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("userName");
        return "redirect:/";
    }

    // Input page
    @RequestMapping(path = "/chat", method = RequestMethod.GET)
    public String input(Model model, HttpSession session, String message) {

//        session.setAttribute("message", message);
//        model.addAttribute("message", session.getAttribute("message"));

//        WebChatClient myWebChatClient = new WebChatClient();
//        String serverResponse = myWebChatClient.sendMessage(message);
//        System.out.println(serverResponse);


//        model.addAttribute("message", session.getAttribute("message"));

        return "input";
    }

    //They can both be /chat, post sends the info,
    @RequestMapping(path = "/chat", method = RequestMethod.POST)
    public String send(HttpSession session, String message) {
        session.setAttribute("message", message);
//        System.out.println("Message: " + message);
        myWebChatClient = new WebChatClient();
        String serverResponse = myWebChatClient.sendMessage(message);
        System.out.println(serverResponse);
        return "redirect:/chat";
    }

//    @RequestMapping(path = "/chat", method = RequestMethod.POST)
//    public String input(Model model, HttpSession session, String message) {
//        session.setAttribute("message", message);
//        System.out.println("Message: " + message);
//        WebChatClient myWebChatClient = new WebChatClient();
//        String serverResponse = myWebChatClient.sendMessage(message);
//        System.out.println(serverResponse);
//
//        return "input";
//    }
    @RequestMapping(path = "/sendHistory", method = RequestMethod.POST)
    public String sendHistory(HttpSession session) {
//        System.out.println("IN SEND HISTORY PATH");
        if (myWebChatClient == null) {
            System.out.println("No history to display...");
        } else {
//            System.out.println("in else block on send history path");
            ArrayList<String> responses = myWebChatClient.sendHistoryMessage();
            for (String response : responses) {
                System.out.println("*" + response);
            }
        }
        return "redirect:/chat";
    }
}
