package ra.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.response.ApiDataResponse;
import ra.demo.model.entity.Classes;
import ra.demo.service.ClassService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Classes>>> getClasses() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách lớp học thành công!",
                classService.getClasses(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Classes>> insertClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới lớp học thành công!",
                classService.insertClasses(classes),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @GetMapping("/get-classes-by-name/{className}")
    public ResponseEntity<ApiDataResponse<List<Classes>>> getClassesByName(@PathVariable("className") String className) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách lớp học " + className + " thành công",
                classService.getClassesByName(className),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/get-class-by-name-and-status/{className}/{status}")
    public ResponseEntity<ApiDataResponse<List<Classes>>> getClassesByNameAndStatus(@PathVariable("className") String className,
                                                                                    @PathVariable("status") Boolean status) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách lớp học " + className + " thành công",
                classService.getClassesByNameAndStatus(className, status),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
