package kodlama.io.rentACar3.business.abstracts;

import kodlama.io.rentACar3.business.requests.CreateModelRequest;
import kodlama.io.rentACar3.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
