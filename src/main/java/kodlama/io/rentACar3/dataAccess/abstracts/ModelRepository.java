package kodlama.io.rentACar3.dataAccess.abstracts;

import kodlama.io.rentACar3.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
