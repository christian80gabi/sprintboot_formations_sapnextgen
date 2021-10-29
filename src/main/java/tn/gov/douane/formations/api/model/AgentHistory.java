package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "agent_history")
public class AgentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_history_id")
    private long id;

    @Column(name = "agent_history_username")
    private String agentHistoryUsername;

    @Column(name = "agent_history_password")
    private String agentHistoryPassword;

    @Column(name = "agent_history_create_at")
    private Timestamp agentHistoryCreateAt;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agentId;

    public AgentHistory() {
    }

    public AgentHistory(String agentHistoryUsername, String agentHistoryPassword, Timestamp agentHistoryCreateAt) {
        this.agentHistoryUsername = agentHistoryUsername;
        this.agentHistoryPassword = agentHistoryPassword;
        this.agentHistoryCreateAt = agentHistoryCreateAt;
    }

    public AgentHistory(AgentHistory agentHistory) {
        this.id = agentHistory.id;
        this.agentHistoryUsername = agentHistory.agentHistoryUsername;
        this.agentHistoryPassword = agentHistory.agentHistoryPassword;
        this.agentHistoryCreateAt = agentHistory.agentHistoryCreateAt;
        this.agentId = agentHistory.agentId;
    }

    public long getId() {
        return id;
    }

    public String getAgentHistoryUsername() {
        return agentHistoryUsername;
    }

    public void setAgentHistoryUsername(String agentHistoryUsername) {
        this.agentHistoryUsername = agentHistoryUsername;
    }

    public String getAgentHistoryPassword() {
        return agentHistoryPassword;
    }

    public void setAgentHistoryPassword(String agentHistoryPassword) {
        this.agentHistoryPassword = agentHistoryPassword;
    }

    public Timestamp getAgentHistoryCreateAt() {
        return agentHistoryCreateAt;
    }

    public void setAgentHistoryCreateAt(Timestamp agentHistoryCreateAt) {
        this.agentHistoryCreateAt = agentHistoryCreateAt;
    }

    public Agent getAgentId() {
        return agentId;
    }

    public void setAgentId(Agent agentId) {
        this.agentId = agentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgentHistory)) return false;
        AgentHistory that = (AgentHistory) o;
        return getId() == that.getId() &&
                getAgentHistoryUsername().equals(that.getAgentHistoryUsername()) &&
                getAgentHistoryPassword().equals(that.getAgentHistoryPassword()) &&
                getAgentHistoryCreateAt().equals(that.getAgentHistoryCreateAt()) &&
                Objects.equals(getAgentId(), that.getAgentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAgentHistoryUsername(), getAgentHistoryPassword(), getAgentHistoryCreateAt(), getAgentId());
    }
}
