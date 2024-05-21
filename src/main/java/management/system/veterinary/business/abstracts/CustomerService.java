package management.system.veterinary.business.abstracts;

import management.system.veterinary.entities.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    Customer get(long id);
    Customer getByName(String name);
    Customer update(Customer customer);
    boolean delete(long id);
//    boolean existsByPhone(String phone);
}
