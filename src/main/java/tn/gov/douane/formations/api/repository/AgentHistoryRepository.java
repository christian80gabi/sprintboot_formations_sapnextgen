package tn.gov.douane.formations.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.gov.douane.formations.api.model.AgentHistory;

public interface AgentHistoryRepository extends JpaRepository<AgentHistory, Long> {
}
