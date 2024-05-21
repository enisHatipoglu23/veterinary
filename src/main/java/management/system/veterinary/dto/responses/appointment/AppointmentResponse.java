package management.system.veterinary.dto.responses.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private long id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Doctor doctor;
}
