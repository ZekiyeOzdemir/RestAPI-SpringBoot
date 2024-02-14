package kodlama.io.rentACar3.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllModelsResponse {
    private int id;
    private String name;
    private String brandName;
}
