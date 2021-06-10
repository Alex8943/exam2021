package com.example.demo.Controller;

import com.example.demo.Service.KommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @Autowired
    KommuneService kommuneService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("kommuner", kommuneService.findAllKommune());
        return "index";
    }
}
