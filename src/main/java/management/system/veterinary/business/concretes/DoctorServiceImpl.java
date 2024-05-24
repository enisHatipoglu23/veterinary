package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Doctor;
import management.system.veterinary.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements management.system.veterinary.business.abstracts.DoctorServiceImpl {

    private final DoctorRepository doctorRepository;
    @Override
    public Doctor save(Doctor doctor) {
        // kontrol ekle
        return this.doctorRepository.save(doctor);
    }

    @Override
    public Doctor getByName(String name) {
        return this.doctorRepository.findByName(name);
    }
    @Override
    public Doctor get(long id) {
        return this.doctorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Doctor update(Doctor doctor) {
        this.get(doctor.getId());
        return this.doctorRepository.save(doctor);
    }



    @Override
    public boolean delete(long id) {
        Doctor doctor = this.get(id);
        this.doctorRepository.delete(doctor);
        return true;
    }
}
