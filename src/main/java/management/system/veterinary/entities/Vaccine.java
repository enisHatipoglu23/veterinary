package management.system.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vaccines")
@Data
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "protection_start_date")
    private LocalDate protectionStartDate;

    @Column(name = "protection_end_date")
    private LocalDate protectionEndDate;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
