package management.system.veterinary.dto.requests.vaccine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Animal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {
    @NotNull(message = "Vaccine name cannot be null.")
    private String name;
    @NotNull(message = "Vaccine CODE cannot be null.")
    private String code;
    @NotNull(message = "Protection start date cannot be null.")
    private LocalDate protectionStartDate;
    @NotNull(message = "Protection end date cannot be null.")
    private LocalDate protectionEndDate;
    @NotNull(message = "Animal ID cannot be null.")
    private long animalId;
}
