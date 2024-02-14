package kodlama.io.rentACar3.webApi;

import jakarta.validation.Valid;
import kodlama.io.rentACar3.business.abstracts.BrandService;
import kodlama.io.rentACar3.business.requests.CreateBrandRequest;
import kodlama.io.rentACar3.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar3.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar3.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable  int id) {
        return this.brandService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }
}
