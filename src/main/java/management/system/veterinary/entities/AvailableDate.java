package management.system.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Data
@NoArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id")
    private long id;

    @Column(name = "available_date")
    private LocalDate availableDate;

    @ManyToOne
    @JoinColumn(name = "available_date_doctor_id")
    private Doctor doctor;
}
