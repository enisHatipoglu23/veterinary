package management.system.veterinary.dto.requests.vaccine;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Animal;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {

    @Positive(message = "ID should be positive number")
    @NotNull
    @NotEmpty
    private long id;

    @NotNull(message = "Category name cannot be null or empty")
    private String name;

    @NotNull(message = "Category name cannot be null or empty")
    private String code;

    @NotNull(message = "Category name cannot be null or empty")
    private LocalDate protectionStartDate;

    @NotNull(message = "Category name cannot be null or empty")
    private LocalDate protectionEndDate;
}
