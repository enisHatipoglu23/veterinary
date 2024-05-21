package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.business.abstracts.AppointmentService;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.Customer;
import management.system.veterinary.repository.AppointmentRepository;
import management.system.veterinary.repository.AvailableDateRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AvailableDateRepository availableDateRepository;
    @Override
    public Appointment save(Appointment appointment) {

        boolean hasExactAppointment = appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor(), appointment.getAppointmentDate(), appointment.getAppointmentTime());

        if (hasExactAppointment) {
            throw new IllegalArgumentException("Doctor already has an appointment at this date and time.");
        }


        List<Appointment> existingAppointments = appointmentRepository.findByDoctorAndAppointmentDate(
                appointment.getDoctor(), appointment.getAppointmentDate());

        for (Appointment existingAppointment : existingAppointments) {

            long timeDifference = Math.abs(Duration.between(existingAppointment.getAppointmentTime(), appointment.getAppointmentTime()).toHours());


            if (timeDifference < 2) {
                throw new IllegalArgumentException("There should be at least 2 hours between appointments.");
            }
        }


        boolean isAvailableDate = availableDateRepository.existsByDoctorAndAvailableDate(
                appointment.getDoctor(), appointment.getAppointmentDate());

        if (!isAvailableDate) {
            throw new IllegalArgumentException("Doctor is not available on this date.");
        }

        return this.appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getByDateBetweenAndAnimalName(LocalDate startDate, LocalDate endDate, String animalName) {
        return this.appointmentRepository.findByAppointmentDateBetweenAndAnimalName(startDate,endDate,animalName);
    }

    @Override
    public Appointment get(long id) {
        return this.appointmentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Appointment update(Appointment appointment) {
        this.get(appointment.getId());
        return this.appointmentRepository.save(appointment);
    }
    @Override
    public boolean delete(long id) {
        Appointment appointment = this.get(id);
        this.appointmentRepository.delete(appointment);
        return true;
    }
}
