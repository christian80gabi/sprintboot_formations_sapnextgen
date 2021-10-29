package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agent", uniqueConstraints = @UniqueConstraint(columnNames = {"agent_matricule", "agent_email", "agent_phone"}))
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id")
    private long id;

    @Column(name = "agent_matricule")
    private String agentMatricule;

    @Column(name = "agent_first_name")
    private String agentFirstName;

    @Column(name = "agent_last_name")
    private String agentLastName;

    @Column(name = "agent_email")
    private String agentEmail;

    @Column(name = "agent_phone")
    private String agentPhone;

    @Column(name = "agent_type")
    private String agentType;

    @Column(name = "agent_grade")
    private String agentGrade;

    @Column(name = "agent_poste")
    private String agentPoste;

    @Column(name = "agent_mail_envoi")
    private boolean envoyer;

    public Agent() {
    }

    public Agent(String agentMatricule, String agentFirstName, String agentLastName, String agentEmail,
                 String agentPhone, String agentType, String agentGrade, String agentPoste) {
        this.agentMatricule = agentMatricule;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.agentEmail = agentEmail;
        this.agentPhone = agentPhone;
        this.agentType = agentType;
        this.agentGrade = agentGrade;
        this.agentPoste = agentPoste;
    }

    public Agent(Agent agent) {
        this.id = agent.id;
        this.agentMatricule = agent.agentMatricule;
        this.agentFirstName = agent.agentFirstName;
        this.agentLastName = agent.agentLastName;
        this.agentEmail = agent.agentEmail;
        this.agentPhone = agent.agentPhone;
        this.agentType = agent.agentType;
        this.agentGrade = agent.agentGrade;
        this.agentPoste = agent.agentPoste;
    }

    public long getId() {
        return id;
    }

    public String getAgentMatricule() {
        return agentMatricule;
    }

    public void setAgentMatricule(String agentMatricule) {
        this.agentMatricule = agentMatricule;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAgentGrade() {
        return agentGrade;
    }

    public void setAgentGrade(String agentGrade) {
        this.agentGrade = agentGrade;
    }

    public String getAgentPoste() {
        return agentPoste;
    }

    public void setAgentPoste(String agentPoste) {
        this.agentPoste = agentPoste;
    }

    public boolean isEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(boolean envoyer) {
        this.envoyer = envoyer;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", agentMatricule='" + agentMatricule + '\'' +
                ", agentFirstName='" + agentFirstName + '\'' +
                ", agentLastName='" + agentLastName + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", agentPhone='" + agentPhone + '\'' +
                ", agentType='" + agentType + '\'' +
                ", agentGrade='" + agentGrade + '\'' +
                ", agentPoste='" + agentPoste + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agent)) return false;
        Agent agent = (Agent) o;
        return getId() == agent.getId() &&
                getAgentMatricule().equals(agent.getAgentMatricule()) &&
                getAgentFirstName().equals(agent.getAgentFirstName()) &&
                getAgentLastName().equals(agent.getAgentLastName()) &&
                getAgentEmail().equals(agent.getAgentEmail()) &&
                getAgentPhone().equals(agent.getAgentPhone()) &&
                getAgentType().equals(agent.getAgentType()) &&
                getAgentGrade().equals(agent.getAgentGrade()) &&
                getAgentPoste().equals(agent.getAgentPoste());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAgentMatricule(), getAgentFirstName(), getAgentLastName(), getAgentEmail(), getAgentPhone(), getAgentType(), getAgentGrade(), getAgentPoste());
    }
}
