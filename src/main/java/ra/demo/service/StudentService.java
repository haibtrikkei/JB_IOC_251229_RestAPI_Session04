package ra.demo.service;

import org.springframework.data.domain.Page;
import ra.demo.model.entity.Student;

public interface StudentService {
    Page<Student> getStudents(Integer page, Integer pageSize);

    Student insertStudent(Student student);
}
