package management.system.veterinary.repository;

import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);
    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);

    List<Appointment> findByAppointmentDateBetweenAndAnimalName(LocalDate startDate, LocalDate endDate, String animalName);
}
