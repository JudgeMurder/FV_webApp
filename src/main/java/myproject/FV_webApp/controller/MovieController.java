package myproject.FV_webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/homepage")
public class MovieController {

//    http://localhost:8080/homepage/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString() {
        return "TEST";
    }
}
