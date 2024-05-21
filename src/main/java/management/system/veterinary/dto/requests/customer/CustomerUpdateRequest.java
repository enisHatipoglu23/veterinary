package management.system.veterinary.dto.requests.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @Positive(message = "Id must be a positive number.")
    @NotNull
    private long id;
    @NotNull(message = "Customer name cannot be null.")
    @NotEmpty
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String mail;
    @NotNull
    private String address;
    @NotNull
    private String city;
}
