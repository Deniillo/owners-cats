package itmo.deniill.dao.repositories;

import itmo.deniill.dao.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer>, JpaSpecificationExecutor<Cat> {
}
