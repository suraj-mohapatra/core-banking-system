package io.github.cbs.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {
    @GetMapping({"/", ""})
    public String foo() {
        return "Hello from CBS!";
    }

}
