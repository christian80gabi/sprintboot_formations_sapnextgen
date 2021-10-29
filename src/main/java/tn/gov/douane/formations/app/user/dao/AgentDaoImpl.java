package tn.gov.douane.formations.app.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.app.URL_INFO;
import tn.gov.douane.formations.app.user.dao.interfaces.IAgentDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgentDaoImpl implements IAgentDao {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private static final String GET_ALL_AGENT_API = URL_INFO.url+"agent";
    private static final String GET_AGENT_BY_ID_API = URL_INFO.url+"agent"+"/"+"{id}";
    private static final String GET_AGENT_BY_MATRICULE = URL_INFO.url+"agent"+"/"+"agentmatricule"+"/"+"{matricule}";
    private static final String GET_AGENT_BY_EMAIL = URL_INFO.url+"agent"+"/"+"agentemail"+"/"+"{email}";
    private static final String POST_AGENT_BY_USERNAME_PASSWORD = URL_INFO.url+"agent"+"/"+"agentidentifiant"+"/";
    private static final String CREATE_AGENTS = URL_INFO.url+"agents";
    private static final String CREATE_AGENT = URL_INFO.url+"agent";
    private static final String UPDATE_AGENT = URL_INFO.url+"agent"+"/"+"{id}";

    public AgentDaoImpl() {
    }

    @Override
    public Agent createAgent(AgentDto dto) {
        Agent agent = restTemplate.postForObject(CREATE_AGENT, dto, Agent.class);

        return agent;
    }

    @Override
    public List<Agent> createAgents(List<AgentDto> dtos) {
        Agent[] list = restTemplate.postForObject(CREATE_AGENTS, dtos, Agent[].class);

        List<Agent> agents = Arrays.asList(list);

        return agents;
    }

    @Override
    public Agent updateAgent(AgentDto dto) {
        restTemplate.put(UPDATE_AGENT, dto, dto.getId());
        Agent agent = getAgentById(dto.getId());

        return agent;
    }

    @Override
    public Agent getAgentById(long id) {
        Agent agent = restTemplate.getForObject(GET_AGENT_BY_ID_API, Agent.class, id);

        return agent;
    }

    @Override
    public Agent getAgentByMatricule(String matricule) {
        Agent agent = restTemplate.getForObject(GET_AGENT_BY_MATRICULE, Agent.class, matricule);

        return agent;
    }

    @Override
    public Agent getAgentByEmail(String email) {
        Agent agent = restTemplate.getForObject(GET_AGENT_BY_EMAIL, Agent.class, email);

        return agent;
    }

    @Override
    public Agent getAgentByUsernamePassword(AgentDto dto) {
        Agent agent = restTemplate.postForObject(POST_AGENT_BY_USERNAME_PASSWORD, dto, Agent.class);

        return agent;
    }

    @Override
    public List<Agent> getAllAgent() {
        Agent[] list = restTemplate.getForObject(GET_ALL_AGENT_API, Agent[].class);
        List<Agent> agents = Arrays.asList(list);

        return agents;
    }

    @Override
    public List<Agent> getAllAgentBySendMailStatut(Boolean statut) {

        List<Agent> listAgents = getAllAgent();
        List<Agent> resultat = new ArrayList<Agent>();

        for (Agent obj : listAgents) {

            if (statut.equals(obj.isEnvoyer())){
                resultat.add(obj);
            }
        }

        return resultat;
    }

    @Override
    public boolean existsAgents(List<AgentDto> dtos) {

        int nbEnregistres = dtos.size();
        int nbExists = 0;
        boolean reponse = false;

        for (AgentDto agent : dtos) {
            if (existsAgent(agent)){
                nbExists++;
            }
        }

        if (nbExists == nbEnregistres){
            reponse = true;
        }

        return reponse;
    }

    @Override
    public boolean existsAgent(AgentDto dto) {

        boolean reponse = false;
        List<Agent> liste = this.getAllAgent();
        String matricule = dto.getMatricule();

        for (Agent agent : liste) {
            if (matricule.equalsIgnoreCase(agent.getAgentMatricule())){
                reponse = true;
                break;
            }
        }

        return reponse;
    }
}
