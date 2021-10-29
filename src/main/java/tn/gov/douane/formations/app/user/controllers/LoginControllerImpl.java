package tn.gov.douane.formations.app.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.app.Session;
import tn.gov.douane.formations.app.user.controllers.interfaces.ILoginController;
import tn.gov.douane.formations.app.user.metiers.LoginMetierImpl;

@Controller
public class LoginControllerImpl implements ILoginController {

    private LoginMetierImpl metier = new LoginMetierImpl();

    @ModelAttribute("agentDto")
    public AgentDto agentDto(){ return new AgentDto();}

    @PostMapping("/agent/first_login")
    @Override
    public String first_login(@ModelAttribute("agentDto") AgentDto agentDto){

          String username = agentDto.getUsername();
          String password = agentDto.getPassword();
          String resultat = "";
          Agent agent = null;

          if ((username.equalsIgnoreCase("")) &&
                (password.equalsIgnoreCase(""))){
              resultat = "redirect:/";
          }else {
              agent = metier.loginAgent(agentDto);
              if (agent != null) {
                  AgentDto dto = new AgentDto();
                  dto.setId((int) agent.getId());
                  dto.setMatricule(agent.getAgentMatricule());
                  dto.setFirstName(agent.getAgentFirstName());
                  dto.setLastName(agent.getAgentLastName());
                  dto.setPhone(agent.getAgentPhone());
                  dto.setEmail(agent.getAgentEmail());
                  dto.setUsername(username);
                  dto.setPassword(password);
                  dto.setGrade(agent.getAgentGrade());
                  dto.setPoste(agent.getAgentPoste());
                  dto.setType(agent.getAgentType());
                  Session.setAGENT(dto);
                  resultat = "redirect:/user/first_connection/change_password";
              }else{
                  resultat = "redirect:/";
              }
          }

          return resultat;
    }

    @PostMapping("/agent/second_login")
    @Override
    public String second_login(String password, String password_again, @ModelAttribute("agentDto") AgentDto agentDto){

          String resultat = "";
          AgentDto agent = Session.getAGENT();

          if (password.equalsIgnoreCase("")){

              if (password_again.equalsIgnoreCase("")){

                  resultat = "redirect:/user/first_connection/insert_matricule";
              }
          }else{

              if (password.equalsIgnoreCase(password_again)){

                  agent.setPassword(password);
                  metier.confirmLoginAgent(agent);
                  Session.setAGENT(agent);

                  resultat = "redirect:/user/first_connection/insert_matricule";
              }else{
                  resultat = "redirect:/user/first_connection/change_password";
              }
          }

          return resultat;
    }

    @PostMapping("/agent/profile")
    @Override
    public String third_login(String matricule, String matricule_again, @ModelAttribute("agentDto") AgentDto agentDto) {

        String resultat = "";
        String session_matriculate = null;
        AgentDto dto = null;

        if (matricule.equalsIgnoreCase("")){

            if (matricule_again.equalsIgnoreCase("")){

                resultat = "redirect:/user/first_connection/insert_matricule";
            }
        }else{

            if (matricule.equalsIgnoreCase(matricule_again)){

                dto = Session.getAGENT();

                if (dto != null){

                    session_matriculate = dto.getMatricule();
                    if (matricule.equalsIgnoreCase(session_matriculate)){

                            dto.setMatricule(matricule);
                            User user = metier.validerAgent(dto);

                            if (user != null){
                                Session.setUSER(user);
                                resultat = "redirect:/user/profile";
                            }else{
                                resultat = "redirect:/user/first_connection/insert_matricule";
                            }
                    }else{
                        resultat = "redirect:/";
                    }
                }else{
                    resultat = "redirect:/";
                }

            }else{
                resultat = "redirect:/user/first_connection/insert_matricule";
            }
        }

        return resultat;
    }
}
