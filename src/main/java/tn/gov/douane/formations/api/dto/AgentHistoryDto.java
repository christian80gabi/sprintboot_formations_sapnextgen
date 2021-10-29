package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Agent;

public class AgentHistoryDto {

    private int id;
    private String username;
    private String password;
    private int agentId;
    private Agent agent;

    public AgentHistoryDto() {
    }

    public AgentHistoryDto(String username, String password, int agentId, Agent agent) {
        this.username = username;
        this.password = password;
        this.agentId = agentId;
        this.agent = agent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
