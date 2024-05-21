package management.system.veterinary.repository;

import management.system.veterinary.entities.AvailableDate;
import management.system.veterinary.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    boolean existsByDoctorAndAvailableDate(Doctor doctor, LocalDate availableDate);
}
