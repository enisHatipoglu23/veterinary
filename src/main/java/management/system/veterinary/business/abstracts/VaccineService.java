package management.system.veterinary.business.abstracts;

import management.system.veterinary.core.result.ResultData;
import management.system.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import management.system.veterinary.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine getById(long id);
    Vaccine update(Vaccine vaccine);
    boolean delete(long id);
    List<Vaccine> getAllByAnimalName(String animalName);
    List<Vaccine> getVaccinesExpiringBetween(LocalDate startDate, LocalDate endDate);
}
