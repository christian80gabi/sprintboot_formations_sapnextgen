package tn.gov.douane.formations.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.gov.douane.formations.api.model.LevelFormation;

@Repository
public interface LevelFormationRepository extends JpaRepository<LevelFormation, Long> {
}
