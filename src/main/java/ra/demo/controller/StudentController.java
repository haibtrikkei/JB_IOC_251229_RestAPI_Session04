package ra.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.response.ApiDataResponse;
import ra.demo.model.entity.Student;
import ra.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @Value("${pageSize}")
    private Integer pageSize;

    @GetMapping
    public ResponseEntity<ApiDataResponse<Page<Student>>> getStudents(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách sinh viên trang " + page + " thành công!",
                studentService.getStudents(page - 1, pageSize),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Student>> insertStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới sinh viên " + student.getFullName() + " thành công",
                studentService.insertStudent(student),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
}
