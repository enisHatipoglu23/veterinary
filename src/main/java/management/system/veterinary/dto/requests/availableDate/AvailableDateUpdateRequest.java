package management.system.veterinary.dto.requests.availableDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Doctor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    @Positive(message = "Id must be a positive number.")
    @NotNull
    @NotEmpty
    private long id;
    @NotNull(message = "Date field cannot be null.")
    private LocalDate availableDate;
    @NotNull(message = "Doctor field cannot be null.")
    private Doctor doctor;
}
