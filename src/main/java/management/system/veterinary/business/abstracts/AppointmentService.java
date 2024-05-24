package management.system.veterinary.business.abstracts;

import management.system.veterinary.entities.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    List<Appointment> getByDateBetweenAndAnimalName(LocalDateTime startDate, LocalDateTime endDate, String animalName);
    Appointment update(Appointment appointment);
    Appointment get(long id);
    boolean delete(long id);
}
