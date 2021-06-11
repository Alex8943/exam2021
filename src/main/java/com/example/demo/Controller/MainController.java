package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/updateSogne")
    public String create(){
        return "updateSogne";
    }

    @GetMapping("/infektionstal")
    public String infektion(){
        return "infektionstal";
    }

    @GetMapping("/sogne")
    public String sogne(){
        return "sogne";
    }
}
