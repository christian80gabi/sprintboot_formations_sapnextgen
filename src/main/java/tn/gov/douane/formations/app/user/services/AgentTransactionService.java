package tn.gov.douane.formations.app.user.services;

import tn.gov.douane.formations.app.user.dao.AgentHistoryDaoImpl;
import tn.gov.douane.formations.app.user.dao.AgentDaoImpl;
import tn.gov.douane.formations.app.user.dao.interfaces.IAgentHistoryDao;
import tn.gov.douane.formations.app.user.dao.interfaces.IAgentDao;

public class AgentTransactionService {

    private IAgentDao agentDao = new AgentDaoImpl();
    private IAgentHistoryDao agentHistoryDao = new AgentHistoryDaoImpl();

    public AgentTransactionService() {
    }

    public AgentTransactionService(IAgentDao agentDao, IAgentHistoryDao agentHistoryDao) {
        this.agentDao = agentDao;
        this.agentHistoryDao = agentHistoryDao;
    }

    public IAgentDao getAgentDao() {
        return agentDao;
    }

    public void setAgentDao(IAgentDao agentDao) {
        this.agentDao = agentDao;
    }

    public IAgentHistoryDao getAgentHistoryDao() {
        return agentHistoryDao;
    }

    public void setAgentHistoryDao(IAgentHistoryDao agentHistoryDao) {
        this.agentHistoryDao = agentHistoryDao;
    }
}
