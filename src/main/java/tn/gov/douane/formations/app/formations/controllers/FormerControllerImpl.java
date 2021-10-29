package tn.gov.douane.formations.app.formations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormerControllerImpl {

    @GetMapping("/mes/formations")
    public String formations(){
        return "redirect:/formations/catalog";
    }

    @GetMapping("/ma/formation")
    public String myFormation(){
        return "redirect:/formations/my_formation";
    }
}
