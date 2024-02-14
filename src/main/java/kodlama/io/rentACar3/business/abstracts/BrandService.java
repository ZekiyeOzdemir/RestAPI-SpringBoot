package kodlama.io.rentACar3.business.abstracts;

import kodlama.io.rentACar3.business.requests.CreateBrandRequest;
import kodlama.io.rentACar3.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar3.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar3.business.responses.GetByIdBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);

    GetByIdBrandResponse getById(int id);

    void delete(int id);

    void update(UpdateBrandRequest updateBrandRequest);
}
