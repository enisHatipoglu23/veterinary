package management.system.veterinary.business.abstracts;

import management.system.veterinary.entities.AvailableDate;

public interface AvailableDateService {
    AvailableDate save(AvailableDate availableDate);
    AvailableDate update(AvailableDate availableDate);
    AvailableDate get(long id);
    boolean delete(long id);
}
