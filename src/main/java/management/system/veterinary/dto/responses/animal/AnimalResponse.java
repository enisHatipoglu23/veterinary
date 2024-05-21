package management.system.veterinary.dto.responses.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.dto.responses.customer.CustomerResponse;
import management.system.veterinary.entities.Customer;
import management.system.veterinary.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private LocalDate dateOfBirth;
    private String customerName;
    private String customerPhone;
}
