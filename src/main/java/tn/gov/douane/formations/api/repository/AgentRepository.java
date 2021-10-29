package tn.gov.douane.formations.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.gov.douane.formations.api.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
