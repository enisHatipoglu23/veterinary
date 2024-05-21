package management.system.veterinary.dto.requests.availableDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Doctor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    @NotNull(message = "Date field cannot be null.")
    private LocalDate availableDate;
    @NotNull(message = "Doctor field cannot be null.")
    private long doctorId;
}
