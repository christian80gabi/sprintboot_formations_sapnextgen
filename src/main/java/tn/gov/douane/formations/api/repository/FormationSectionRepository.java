package tn.gov.douane.formations.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.gov.douane.formations.api.model.FormationSection;

@Repository
public interface FormationSectionRepository extends JpaRepository<FormationSection, Long> {
}
