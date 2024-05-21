package management.system.veterinary.repository;

import management.system.veterinary.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByAnimal_Name(String name);
    List<Vaccine> findByNameAndCodeAndAnimal_Id(String name, String code, long animalId);
    boolean existsByNameAndCodeAndAnimal_IdAndProtectionEndDateAfter(String name, String code, long animalId, LocalDate protectionEndDate);
    List<Vaccine> findByProtectionEndDateBetween(LocalDate startDate, LocalDate endDate);
}
