package management.system.veterinary.dto.requests.animal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Customer;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUpdateRequest {
    @Positive(message = "ID should be positive number")
    private long id;
    @NotNull(message = "Customer name cannot be null.")
    @NotEmpty
    private String name;
    @NotNull
    private String species;
    @NotNull
    private String breed;
    @NotNull
    private String gender;
    @NotNull
    private String color;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull(message = "Customer name cannot be null.")
    private Customer customer;
}
