package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AnimalService;
import management.system.veterinary.business.abstracts.VaccineService;
import management.system.veterinary.core.exception.handler.VaccineStillEffective;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Vaccine;
import management.system.veterinary.repository.VaccineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineManager implements VaccineService {
    private final VaccineRepository vaccineRepository;
    private final AnimalService animalService;


    @Override
    public Vaccine save(Vaccine vaccine) {
        List<Vaccine> existingVaccineList = this.vaccineRepository.findByNameAndCodeAndAnimal_Id(
                vaccine.getName(),
                vaccine.getCode(),
                vaccine.getAnimal().getId()
        );
        for(Vaccine existingVaccine : existingVaccineList){
            if(existingVaccine.getProtectionEndDate().isAfter(vaccine.getProtectionStartDate())){
                throw new VaccineStillEffective();
            }
        }
        //test et.
        Animal animal = this.animalService.get(vaccine.getAnimal().getId());
        vaccine.setAnimal(animal);

        return this.vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine getById(long id) {
        return this.vaccineRepository.findById(id).orElseThrow();
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.getById(vaccine.getId());
        return this.vaccineRepository.save(vaccine);
    }


    @Override
    public boolean delete(long id) {
        this.vaccineRepository.existsById(id);
        this.vaccineRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Vaccine> getAllByAnimalName(String animalName) {
        return this.vaccineRepository.findByAnimal_Name(animalName);
    }


    @Override
    public List<Vaccine> getVaccinesExpiringBetween(LocalDate startDate, LocalDate endDate) {
        return this.vaccineRepository.findByProtectionEndDateBetween(startDate,endDate);
    }
}
