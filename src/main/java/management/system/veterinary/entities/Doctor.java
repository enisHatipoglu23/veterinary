package management.system.veterinary.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_phone_number")
    private String phone;

    @Column(name = "doctor_mail")
    private String mail;

    @Column(name = "doctor_address")
    private String address;

    @Column(name = "doctor_city")
    private String city;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<AvailableDate> availableDateList;
}
