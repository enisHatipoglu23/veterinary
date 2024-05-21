package management.system.veterinary.dto.requests.doctor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.entities.AvailableDate;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {
    @NotNull(message = "Doctor name cannot be null.")
    @NotEmpty
    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
