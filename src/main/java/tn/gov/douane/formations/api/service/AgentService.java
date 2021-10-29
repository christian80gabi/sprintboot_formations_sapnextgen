package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.AgentHistory;
import java.util.List;


public interface AgentService {

    public List<Agent> getAllAgent();
    public Agent getAgentById(long objId);
    public Agent getAgentByMatricule(String matricule);
    public Agent getAgentByEmail(String email);
    public Agent getAgentByUsernamePassword(AgentDto agentDto);
    public List<Agent> createAgents(List<AgentDto> agentsDto);
    public Agent createAgent(AgentDto agentDto);
    public Agent updateAgent(AgentDto agentDto, long objId);
    public ResponseEntity<Agent> deleteAgent(long objId);
    public List<AgentHistory> getAllAgentHistory();
    public AgentHistory getAgentHistoryById(long objId);
    public AgentHistory createAgentHistory(AgentHistoryDto agentHistoryDto);

}
