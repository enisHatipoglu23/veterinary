package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.CustomerService;
import management.system.veterinary.core.exception.CustomerAlreadyExistsException;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Customer;
import management.system.veterinary.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
//        if(this.existsByPhone(customer.getPhone())){
//            throw new CustomerAlreadyExistsException();
//        }
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer get(long id) {
        return this.customerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Customer getByName(String name) {
        return this.customerRepository.findByName(name);
    }

    @Override
    public Customer update(Customer customer) {
        this.get(customer.getId());
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean delete(long id) {
        Customer customer = this.get(id);
        this.customerRepository.delete(customer);
        return true;
    }

//    @Override
//    public boolean existsByPhone(String phone) {
//        if (this.customerRepository.existsByPhone(phone)){
//            return true;
//        }
//        return false;
//    }

}
