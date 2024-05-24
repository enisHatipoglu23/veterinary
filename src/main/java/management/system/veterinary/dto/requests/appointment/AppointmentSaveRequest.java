package management.system.veterinary.dto.requests.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {
    @NotNull(message = "Appointment date cannot be null.")
    private LocalDateTime appointmentDateTime;

    @NotNull(message = "Doctor field cannot be null.")
    private long doctorId;

    @NotNull(message = "Animal field cannot be null.")
    private long animalId;
}
