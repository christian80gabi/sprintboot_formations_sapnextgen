package tn.gov.douane.formations.app.user.dao.interfaces;

import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.model.AgentHistory;
import java.util.List;

public interface IAgentHistoryDao {
    public AgentHistory createAgentHistory(AgentHistoryDto dto);
    public AgentHistory getAgentHistoryById(long id);
    public List<AgentHistory> getAllAgentHistory();
}
