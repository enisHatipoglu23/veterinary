package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements management.system.veterinary.business.abstracts.AnimalService {

    private final AnimalRepository animalRepository;
    @Override
    public Animal save(Animal animal) {
        if(animal.getCustomer() == null){
            throw new IllegalArgumentException("Animal must be associated with a customer before saving.");
        }
        return this.animalRepository.save(animal);
    }

    @Override
    public Animal get(long id) {
        return this.animalRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Animal getByName(String name) {
        try{
            Animal animal = this.animalRepository.findByName(name);
        }catch (Exception e){
            throw new NotFoundException();
        }
        return this.animalRepository.findByName(name);
    }

    @Override
    public Animal update(Animal animal) {
        this.get(animal.getId());
        return this.animalRepository.save(animal);
    }

    @Override
    public boolean delete(long id) {
        Animal animal = this.get(id);
        this.animalRepository.delete(animal);
        return true;
    }
}
