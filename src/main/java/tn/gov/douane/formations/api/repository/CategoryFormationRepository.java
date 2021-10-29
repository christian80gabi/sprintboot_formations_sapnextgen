package tn.gov.douane.formations.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.gov.douane.formations.api.model.CategoryFormation;

@Repository
@Transactional
public interface CategoryFormationRepository extends JpaRepository<CategoryFormation, Long> {
}
