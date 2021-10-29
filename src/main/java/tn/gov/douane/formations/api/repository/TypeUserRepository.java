package tn.gov.douane.formations.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.gov.douane.formations.api.model.TypeUser;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {
}
