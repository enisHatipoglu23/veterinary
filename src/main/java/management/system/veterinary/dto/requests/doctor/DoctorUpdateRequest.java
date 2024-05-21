package management.system.veterinary.dto.requests.doctor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    @Positive(message = "Id must be a positive number.")
    @NotNull
    @NotEmpty
    private long id;
    @NotNull(message = "Doctor name cannot be null.")
    @NotEmpty
    private String name;
    @NotNull(message = "Doctor phone cannot be null.")
    private String phone;
    @NotNull(message = "Doctor mail cannot be null.")
    private String mail;
    @NotNull(message = "Doctor address cannot be null.")
    private String address;
    @NotNull(message = "Doctor city cannot be null.")
    private String city;
}
