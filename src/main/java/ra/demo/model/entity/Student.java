package ra.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long stuId;
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;
    private Boolean gender;
    private LocalDate birthday;
    private String address;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;
}
