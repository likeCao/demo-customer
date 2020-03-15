package com.class1804.democustomer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/login")
    public String apparatus(){
        return "login";

    }
}
