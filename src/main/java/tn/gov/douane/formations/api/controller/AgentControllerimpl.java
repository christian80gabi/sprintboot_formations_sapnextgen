package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.AgentHistory;
import tn.gov.douane.formations.api.service.AgentServiceImpl;
import java.util.List;

@RestController
public class AgentControllerimpl implements AgentController{

    @Autowired
    private AgentServiceImpl service;

    public AgentControllerimpl() {
        super();
    }

    public AgentControllerimpl(AgentServiceImpl service) {
        super();
        this.service = service;
    }

    @GetMapping("/agent")
    @Override
    public List<Agent> getAllAgent() {
        return this.service.getAllAgent();
    }

    @GetMapping("/agent/{id}")
    @Override
    public Agent getAgentById(@PathVariable(value = "id") long objId) {
        return this.service.getAgentById(objId);
    }

    @GetMapping("/agent/agentmatricule/{matricule}")
    @Override
    public Agent getAgentByMatricule(@PathVariable(value = "matricule") String matricule) {
        return this.service.getAgentByMatricule(matricule);
    }

    @GetMapping("/agent/agentemail/{email}")
    @Override
    public Agent getAgentByEmail(@PathVariable(value = "email") String email) {
        return this.service.getAgentByEmail(email);
    }

    @PostMapping("/agent/agentidentifiant/")
    @Override
    public Agent getAgentByUsernamePassword(@RequestBody AgentDto agentDto) {
        return this.service.getAgentByUsernamePassword(agentDto);
    }

    @GetMapping("/agenthistory")
    @Override
    public List<AgentHistory> getAllAgentHistory() {
        return this.service.getAllAgentHistory();
    }

    @GetMapping("/agenthistory/{id}")
    @Override
    public AgentHistory getAgentHistoryById(@PathVariable(value = "id") long objId) {
        return this.service.getAgentHistoryById(objId);
    }

    @PostMapping("/agents")
    @Override
    public List<Agent> createAgents(@RequestBody List<AgentDto> agentsDto) {
        return this.service.createAgents(agentsDto);
    }

    @PostMapping("/agenthistory")
    @Override
    public AgentHistory createAgentHistory(@RequestBody AgentHistoryDto agentHistoryDto) {

        Agent agent = this.service.getAgentById(agentHistoryDto.getAgentId());
        agentHistoryDto.setAgent(agent);

        return this.service.createAgentHistory(agentHistoryDto);
    }

    @PostMapping("/agent")
    @Override
    public Agent createAgent(@RequestBody AgentDto agentDto) {
        return this.service.createAgent(agentDto);
    }

    @PutMapping("/agent/{id}")
    @Override
    public Agent updateAgent(@RequestBody AgentDto agentDto, @PathVariable(value = "id") long objId) {
        return this.service.updateAgent(agentDto, objId);
    }

    @DeleteMapping("/agent/{id}")
    @Override
    public ResponseEntity<Agent> deleteAgent(@PathVariable(value = "id") long objId) {
        return this.service.deleteAgent(objId);
    }
}
