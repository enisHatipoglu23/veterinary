package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AvailableDateService;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.AvailableDate;
import management.system.veterinary.entities.Customer;
import management.system.veterinary.repository.AvailableDateRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements AvailableDateService {

    private final AvailableDateRepository availableDateRepository;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        this.get(availableDate.getId());
        return this.availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate get(long id) {
        return this.availableDateRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean delete(long id) {
        AvailableDate availableDate = this.get(id);
        this.availableDateRepository.delete(availableDate);
        return true;
    }
}
