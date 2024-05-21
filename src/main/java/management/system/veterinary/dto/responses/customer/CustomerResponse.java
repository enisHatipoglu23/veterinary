package management.system.veterinary.dto.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.entities.Animal;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private long id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
    private List<AnimalResponse> animalList;
}
