package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.AgentHistory;
import tn.gov.douane.formations.api.repository.AgentHistoryRepository;
import tn.gov.douane.formations.api.repository.AgentRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository repo;

    @Autowired
    private AgentHistoryRepository repoAgentHistory;

    public AgentServiceImpl() {
        super();
    }

    public AgentServiceImpl(AgentRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Agent> getAllAgent() {
        return this.repo.findAll();
    }

    @Override
    public Agent getAgentById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Agent not found with id :"+objId)
                );
    }

    @Override
    public Agent getAgentByMatricule(String matricule) {

        List<Agent> agents = repo.findAll();
        Agent agent = null;

        for (Agent obj : agents) {

            if (matricule.equalsIgnoreCase(obj.getAgentMatricule())){
                agent = new Agent(obj);
                break;
            }
        }

        return agent;
    }

    @Override
    public Agent getAgentByEmail(String email) {

        List<Agent> agents = repo.findAll();
        Agent agent = null;

        for (Agent obj : agents) {

            if (email.equalsIgnoreCase(obj.getAgentEmail())){
                agent = new Agent(obj);
                break;
            }
        }

        return agent;
    }

    @Override
    public Agent getAgentByUsernamePassword(AgentDto agentDto) {

        List<AgentHistory> agentIdentifiants = repoAgentHistory.findAll();
        AgentHistory agentHistory = null;
        Agent agent = null;
        String username = agentDto.getUsername();
        String password = agentDto.getPassword();

        for (AgentHistory obj: agentIdentifiants) {

            if (username.equalsIgnoreCase(obj.getAgentHistoryUsername())){

                if (password.equalsIgnoreCase(obj.getAgentHistoryPassword())){
                    agentHistory = new AgentHistory(obj);
                    break;
                }
            }
        }

        if (agentHistory != null){

            long idAgent = agentHistory.getAgentId().getId();

            agent = new Agent(this.getAgentById(idAgent));
        }

        return agent;
    }

    @Override
    public List<Agent> createAgents(List<AgentDto> agentsDto) {

        List<Agent> agents = new ArrayList<Agent>();
        List<Agent> tampon = new ArrayList<Agent>();

        for (AgentDto obj: agentsDto) {
            Agent agent = new Agent(obj.getMatricule(),obj.getFirstName(),
                    obj.getLastName(),obj.getEmail(),obj.getPhone(),
                    obj.getType(), obj.getGrade(), obj.getPoste());
            tampon.add(agent);
        }

        agents.addAll(this.repo.saveAll(tampon));

        return agents;
    }

    @Override
    public Agent createAgent(AgentDto agentDto) {

        Agent agent = new Agent(agentDto.getMatricule(),agentDto.getFirstName(),
                agentDto.getLastName(),agentDto.getEmail(),agentDto.getPhone(),
                agentDto.getType(), agentDto.getGrade(), agentDto.getPoste());
        agent.setEnvoyer(agentDto.isEnvoyer());

        return this.repo.save(agent);
    }

    @Override
    public Agent updateAgent(AgentDto agentDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Agent existingAgent = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Agent not found with id :"+objId));

        existingAgent.setAgentMatricule(agentDto.getMatricule());
        existingAgent.setAgentFirstName(agentDto.getFirstName());
        existingAgent.setAgentLastName(agentDto.getLastName());
        existingAgent.setAgentEmail(agentDto.getEmail());
        existingAgent.setAgentPhone(agentDto.getPhone());
        existingAgent.setAgentGrade(agentDto.getGrade());
        existingAgent.setAgentPoste(agentDto.getPoste());
        existingAgent.setAgentType(agentDto.getType());

        return this.repo.save(existingAgent);
    }

    @Override
    public ResponseEntity<Agent> deleteAgent(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Agent existingAgent = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Agent not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingAgent);

        return ResponseEntity.ok().build();
    }

    @Override
    public List<AgentHistory> getAllAgentHistory() {
        return this.repoAgentHistory.findAll();
    }

    @Override
    public AgentHistory getAgentHistoryById(long objId) {

        return this.repoAgentHistory.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Agent history not found with id :"+objId)
                );
    }

    @Override
    public AgentHistory createAgentHistory(AgentHistoryDto agentHistoryDto) {

        Timestamp time = GDate.precisionDateTime;

        AgentHistory agentHistory = new AgentHistory();
        agentHistory.setAgentHistoryUsername(agentHistoryDto.getUsername());
        agentHistory.setAgentHistoryPassword(agentHistoryDto.getPassword());
        agentHistory.setAgentHistoryCreateAt(time);
        agentHistory.setAgentId(agentHistoryDto.getAgent());

        return this.repoAgentHistory.save(agentHistory);
    }
}
