package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.core.exception.BeforeOnDateException;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.AvailableDate;
import management.system.veterinary.repository.AvailableDateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AvailableDateServiceImpl implements management.system.veterinary.business.abstracts.AvailableDateService {

    private final AvailableDateRepository availableDateRepository;

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        if(availableDate.getAvailableDate().isAfter(LocalDate.now())){
            return this.availableDateRepository.save(availableDate);
        }else{
            throw new BeforeOnDateException();
        }
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
