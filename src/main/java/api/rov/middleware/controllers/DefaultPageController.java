package api.rov.middleware.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultPageController {

    @RequestMapping("/")
    public String index() {
        return "Hi there";
    }
}
