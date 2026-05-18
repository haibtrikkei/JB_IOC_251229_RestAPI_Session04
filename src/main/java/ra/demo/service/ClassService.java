package ra.demo.service;

import ra.demo.model.entity.Classes;

import java.util.List;

public interface ClassService {
    List<Classes> getClasses();

    //Tìm theo tên lớp và trạng thái sử dụng method query
    List<Classes> getClassesByNameAndStatus(String className, Boolean status);

    //Tìm theo tên lớp sử dụng JPQL
    List<Classes> getClassesByName(String className);
    Classes insertClasses(Classes classes);
}
