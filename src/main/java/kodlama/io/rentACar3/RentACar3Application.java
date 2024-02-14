package kodlama.io.rentACar3;

import kodlama.io.rentACar3.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar3.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar3.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@SpringBootApplication
public class RentACar3Application {

	public static void main(String[] args) {
		SpringApplication.run(RentACar3Application.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler //hata olusursa buraya duser ayrica @RestContollerAdvice
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) //hata status
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
		//return businessException.getMessage() //demek yerine yukaridakini yapiyoruz (ProblemDetails sinifinin kullaniminin sebebi).
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(); //hangi fieldda ne hata var
		validationProblemDetails.setMessage("VALIDATION EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}


}
