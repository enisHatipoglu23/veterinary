package management.system.veterinary.dto.responses.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.dto.responses.appointment.AppointmentResponse;
import management.system.veterinary.dto.responses.availableDate.AvailableDateResponse;
import management.system.veterinary.entities.Appointment;
import management.system.veterinary.entities.AvailableDate;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private long id;
    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

    private List<AvailableDateResponse> availableDateList;

}
