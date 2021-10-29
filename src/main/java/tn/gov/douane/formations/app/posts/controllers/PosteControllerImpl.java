package tn.gov.douane.formations.app.posts.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class PosteControllerImpl {

    @GetMapping("/postes/all")
    public String postes(){
        return "redirect:/postes/all";
    }

    @GetMapping("/postes/vacants")
    public String postesVacants(){
        return "redirect:/postes/vacants";
    }
}
