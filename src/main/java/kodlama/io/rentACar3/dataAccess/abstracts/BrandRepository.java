package kodlama.io.rentACar3.dataAccess.abstracts;

import kodlama.io.rentACar3.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}
