package management.system.veterinary.business.concretes;

import lombok.RequiredArgsConstructor;
import management.system.veterinary.core.exception.BeforeOnDateException;
import management.system.veterinary.core.exception.NotAvailableException;
import management.system.veterinary.core.exception.NotFoundException;
import management.system.veterinary.entities.Appointment;
import management.system.veterinary.repository.AppointmentRepository;
import management.system.veterinary.repository.AvailableDateRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements management.system.veterinary.business.abstracts.AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AvailableDateRepository availableDateRepository;
    @Override
    public Appointment save(Appointment appointment) {
        if(appointment.getAppointmentDateTime().toLocalDate().isAfter(LocalDate.now())){
            // checking if the doctor has an appointment at the same date and time.
            boolean hasExactAppointment = appointmentRepository.existsByDoctorAndAppointmentDateTime(
                    appointment.getDoctor(), appointment.getAppointmentDateTime());

            if (hasExactAppointment) {
                throw new NotAvailableException();
            }

            // list of appointments on the requested day.
            List<Appointment> existingAppointments = appointmentRepository.findByDoctorAndAppointmentDateTime(
                    appointment.getDoctor(), appointment.getAppointmentDateTime());

            for (Appointment existingAppointment : existingAppointments) {
                // time difference between existing appointment and requested appointment time.
                long timeDifference = Math.abs(Duration.between(existingAppointment.getAppointmentDateTime().toLocalTime(), appointment.getAppointmentDateTime().toLocalTime()).toHours());


                if (timeDifference < 2) {
                    throw new IllegalArgumentException("There should be at least 2 hours between appointments.");
                }
            }


            boolean isAvailableDate = availableDateRepository.existsByDoctorAndAvailableDate(
                    appointment.getDoctor(), appointment.getAppointmentDateTime().toLocalDate());

            if (!isAvailableDate) {
                throw new NotAvailableException();
            }

            return this.appointmentRepository.save(appointment);
        }else{
            throw new BeforeOnDateException();
        }


    }

    @Override
    public List<Appointment> getByDateBetweenAndAnimalName(LocalDateTime startDate, LocalDateTime endDate, String animalName) {
        return this.appointmentRepository.findByAppointmentDateTimeBetweenAndAnimalName(startDate,endDate,animalName);
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
