package management.system.veterinary.dto.requests.appointment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {
    @NotNull(message = "Appointment date cannot be null.")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment time cannot be null.")
    private LocalTime appointmentTime;

    @NotNull(message = "Doctor field cannot be null.")
    private Doctor doctor;

    @NotNull(message = "Animal field cannot be null.")
    private long animalId;
}
