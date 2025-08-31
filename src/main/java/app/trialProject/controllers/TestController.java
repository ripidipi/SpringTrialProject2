package app.trialProject.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest req) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        System.out.println("hello " + name + ' ' + surname);

        return "test/hello";
    }

    @GetMapping("/bye")
    public String byePage() {
        return "test/bye";
    }
}
