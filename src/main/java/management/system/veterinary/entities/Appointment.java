package management.system.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long id;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDateTime;

    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id")
    private Animal animal;
}
