package tn.gov.douane.formations.app.user.controllers.interfaces;

import tn.gov.douane.formations.api.dto.AgentDto;

public interface ILoginController {
    public String first_login(AgentDto agentDto);
    public String second_login(String password, String password_again, AgentDto agentDto);
    public String third_login(String matricule, String matricule_again, AgentDto agentDto);
}
