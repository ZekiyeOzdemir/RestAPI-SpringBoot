package kodlama.io.rentACar3.business.rules;

import kodlama.io.rentACar3.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar3.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name) {
        if(this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists");
        }
    }
}
