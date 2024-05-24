package management.system.veterinary.repository;

import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndAppointmentDateTime(Doctor doctor, LocalDateTime appointmentDateTime);
    boolean existsByDoctorAndAppointmentDateTime(Doctor doctor, LocalDateTime appointmentDateTime);

    List<Appointment> findByAppointmentDateTimeBetweenAndAnimalName(LocalDateTime startDate, LocalDateTime endDate, String animalName);
}
