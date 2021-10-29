package tn.gov.douane.formations.app.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import tn.gov.douane.formations.app.user.controllers.interfaces.IProfilController;

@Controller
@ControllerAdvice
public class ProfilControllerImpl implements IProfilController {

    @PostMapping("/agent/profil/photo")
    @Override
    public String change_profil_photo() {
        return "redirect:/user/profile";
    }

    @Override
    public String reset_identifier() {
        return "redirect:/user/profile";
    }

    @Override
    public String add_formation() {
        return "redirect:/user/profile";
    }

    @Override
    public String edit_formation() {
        return "redirect:/user/profile";
    }

    @Override
    public String update_formation() {
        return "redirect:/user/profile";
    }

    @Override
    public String delete_formation() {
        return "redirect:/user/profile";
    }

    @Override
    public String add_experience() {
        return "redirect:/user/profile";
    }

    @Override
    public String edit_experience() {
        return "redirect:/user/profile";
    }

    @Override
    public String update_experience() {
        return "redirect:/user/profile";
    }

    @Override
    public String delete_experience() {
        return "redirect:/user/profile";
    }

    @Override
    public String add_competence() {
        return "redirect:/user/profile";
    }

    @Override
    public String edit_competence() {
        return "redirect:/user/profile";
    }

    @Override
    public String update_competence() {
        return "redirect:/user/profile";
    }

    @Override
    public String delete_competence() {
        return "redirect:/user/profile";
    }
}
