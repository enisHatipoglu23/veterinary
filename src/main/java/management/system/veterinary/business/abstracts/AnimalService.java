package management.system.veterinary.business.abstracts;

import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Customer;

public interface AnimalService {
    Animal save(Animal animal);
    Animal get(long id);
    Animal getByName(String name);
    Animal update(Animal animal);
    boolean delete(long id);
}
