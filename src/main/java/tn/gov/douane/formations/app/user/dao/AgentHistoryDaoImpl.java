package tn.gov.douane.formations.app.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.model.AgentHistory;
import tn.gov.douane.formations.app.URL_INFO;
import tn.gov.douane.formations.app.user.dao.interfaces.IAgentHistoryDao;

import java.util.Arrays;
import java.util.List;

public class AgentHistoryDaoImpl implements IAgentHistoryDao {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private static final String GET_ALL_AGENT_HISTORY = URL_INFO.url+"agenthistory";
    private static final String GET_AGENT_HISTORY_BY_ID = URL_INFO.url+"agenthistory"+"/"+"{id}";
    private static final String CREATE_AGENT_HISTORY = URL_INFO.url+"agenthistory";

    public AgentHistoryDaoImpl() {
    }

    @Override
    public AgentHistory createAgentHistory(AgentHistoryDto dto) {
        AgentHistory agentHistory = restTemplate.postForObject(CREATE_AGENT_HISTORY, dto, AgentHistory.class);

        return agentHistory;
    }

    @Override
    public AgentHistory getAgentHistoryById(long id) {
        AgentHistory agent_history = restTemplate.getForObject(GET_AGENT_HISTORY_BY_ID, AgentHistory.class, id);

        return agent_history;
    }

    @Override
    public List<AgentHistory> getAllAgentHistory() {
        AgentHistory[] list = restTemplate.getForObject(GET_ALL_AGENT_HISTORY, AgentHistory[].class);
        List<AgentHistory> agents_history = Arrays.asList(list);

        return agents_history;
    }
}
