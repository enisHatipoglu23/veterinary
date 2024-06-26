package management.system.veterinary.business.abstracts;

import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Doctor;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor getByName(String name);
    Doctor update(Doctor doctor);
    Doctor get(long id);
    boolean delete(long id);
}
