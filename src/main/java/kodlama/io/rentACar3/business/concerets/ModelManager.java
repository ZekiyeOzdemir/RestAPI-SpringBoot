package kodlama.io.rentACar3.business.concerets;

import kodlama.io.rentACar3.business.abstracts.ModelService;
import kodlama.io.rentACar3.business.requests.CreateModelRequest;
import kodlama.io.rentACar3.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar3.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar3.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar3.entities.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ModelManager implements ModelService {
    ModelRepository modelRepository;
    ModelMapperService modelMapperService;
    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
    }
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream().map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
