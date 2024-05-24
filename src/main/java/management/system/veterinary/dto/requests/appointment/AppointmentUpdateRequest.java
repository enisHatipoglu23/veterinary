package management.system.veterinary.dto.requests.appointment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    @Positive(message = "Id must be a positive number.")
    @NotNull
    @NotEmpty
    private long id;
    @NotNull(message = "Appointment date cannot be null.")
    private LocalDateTime appointmentDateTime;

    @NotNull(message = "Doctor field cannot be null.")
    private long doctorId;

    @NotNull(message = "Animal field cannot be null.")
    private long animalId;
}
