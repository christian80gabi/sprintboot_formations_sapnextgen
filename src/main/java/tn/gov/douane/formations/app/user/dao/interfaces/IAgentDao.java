package tn.gov.douane.formations.app.user.dao.interfaces;

import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.model.Agent;
import java.util.List;

public interface IAgentDao {

    public Agent createAgent(AgentDto dto);
    public List<Agent> createAgents(List<AgentDto> dtos);
    public Agent updateAgent(AgentDto dto);
    public Agent getAgentById(long id);
    public Agent getAgentByMatricule(String matricule);
    public Agent getAgentByEmail(String email);
    public Agent getAgentByUsernamePassword(AgentDto dto);
    public List<Agent> getAllAgent();
    public List<Agent> getAllAgentBySendMailStatut(Boolean statut);
    public boolean existsAgents(List<AgentDto> dtos);
    public boolean existsAgent(AgentDto dto);
}
