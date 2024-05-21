package management.system.veterinary.business.abstracts;

import management.system.veterinary.dto.responses.appointment.AppointmentResponse;
import management.system.veterinary.entities.Animal;
import management.system.veterinary.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    List<Appointment> getByDateBetweenAndAnimalName(LocalDate startDate, LocalDate endDate, String animalName);
    Appointment update(Appointment appointment);
    Appointment get(long id);
    boolean delete(long id);
}
