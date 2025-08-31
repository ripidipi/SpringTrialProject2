package app.trialProject.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);

        return "test/hello";
    }

    @GetMapping("/bye")
    public String byePage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {

        model.addAttribute("message", "Bye " + name + " " + surname);

        return "test/bye";
    }

    @GetMapping("calculate")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        String result;
        switch (action) {
            case "multiplication":
                result = String.format("%s * %s = %s", a, b, a * b);
                break;
            case "addition":
                result = String.format("%s + %s = %s", a, b, (a + b));
                break;
            case "subtraction":
                result = String.format("%s - %s = %s", a, b, (a - b));
                break;
            case "division":
                result = (b == 0) ? "Division by zero" : String.format("%s / %s = %s", a, b, (double) a / b);
                break;
            default:
                result = "action didn't recognise";
        }

        model.addAttribute("result", result);

        return "test/calculator";
    }
}
