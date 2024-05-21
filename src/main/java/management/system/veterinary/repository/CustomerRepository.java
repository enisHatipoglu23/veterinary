package management.system.veterinary.repository;

import management.system.veterinary.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    boolean existsByPhone(String phone);
}
