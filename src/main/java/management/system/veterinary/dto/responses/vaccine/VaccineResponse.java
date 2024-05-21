package management.system.veterinary.dto.responses.vaccine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import management.system.veterinary.dto.responses.animal.AnimalResponse;
import management.system.veterinary.entities.Animal;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {
    private long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionEndDate;
    private AnimalResponse animal;
}
