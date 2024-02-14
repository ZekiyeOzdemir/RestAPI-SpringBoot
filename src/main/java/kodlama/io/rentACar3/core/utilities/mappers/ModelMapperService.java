package kodlama.io.rentACar3.core.utilities.mappers;

import org.modelmapper.ModelMapper;
public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
