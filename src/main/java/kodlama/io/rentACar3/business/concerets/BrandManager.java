package kodlama.io.rentACar3.business.concerets;

import kodlama.io.rentACar3.business.abstracts.BrandService;
import kodlama.io.rentACar3.business.requests.CreateBrandRequest;
import kodlama.io.rentACar3.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar3.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar3.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar3.business.rules.BrandBusinessRules;
import kodlama.io.rentACar3.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar3.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar3.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;
    BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return getByIdBrandResponse;
    }

    @Override
    public void delete(int id) {
       this.brandRepository.deleteById(id);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
}
