package app.trialProject;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.io.InputStream;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/diag-file")
    @ResponseBody
    public String diagFile() throws IOException {

        String real = servletContext.getRealPath("/WEB-INF/views/hello_world.html");
        try (InputStream is = servletContext.getResourceAsStream("/WEB-INF/views/hello_world.html")) {
            return "realPath=" + real + "\nstream=" + (is == null ? "NULL" : ("OK size=" + is.available()));
        }
    }

}
