package kodlama.io.rentACar3.webApi;

import jakarta.validation.Valid;
import kodlama.io.rentACar3.business.abstracts.ModelService;
import kodlama.io.rentACar3.business.requests.CreateModelRequest;
import kodlama.io.rentACar3.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    ModelService modelService;

    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }
    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return this.modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}
