package ra.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.demo.model.entity.Student;
import ra.demo.repository.StudentRepository;
import ra.demo.service.StudentService;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Page<Student> getStudents(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }


}
