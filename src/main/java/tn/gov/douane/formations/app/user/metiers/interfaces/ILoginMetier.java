package tn.gov.douane.formations.app.user.metiers.interfaces;

import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.User;

import javax.mail.MessagingException;
import java.util.List;

public interface ILoginMetier {

   public Agent addAgent(AgentDto dto);
   public void addAgentHistory(AgentHistoryDto dto);
   public List<Agent> addAgents(List<AgentDto> dtos);
   public void sendConnexionIdentifierAgent(List<AgentDto> dtos) throws MessagingException;
   public Agent loginAgent(AgentDto dto);
   public void confirmLoginAgent(AgentDto dto);
   public Agent confirmAgent(AgentDto dto);
   public User validerAgent(AgentDto dto);
   public void loadAgents(List<AgentDto> dtos);
}
