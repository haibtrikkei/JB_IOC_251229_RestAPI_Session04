package ra.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Classes {
    @Id
    @Column(name = "class_id",length = 30, nullable = false, unique = true)
    private String classId;
    @Column(name = "class_name",length = 100, nullable = false, unique = true)
    private String className;
    private Boolean status;

    @OneToMany(mappedBy = "classes")
    @JsonIgnore
    private List<Student> students;
}
