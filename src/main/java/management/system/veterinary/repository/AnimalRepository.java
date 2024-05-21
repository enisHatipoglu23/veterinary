package management.system.veterinary.repository;

import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);
}
