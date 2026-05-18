package ra.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.demo.model.entity.Classes;
import ra.demo.repository.ClassRepository;
import ra.demo.service.ClassService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    @Override
    public List<Classes> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public List<Classes> getClassesByNameAndStatus(String className, Boolean status) {
        //cài đặt theo method query
        return classRepository.findAllByClassNameContainingAndStatus(className,status);
    }

    @Override
    public List<Classes> getClassesByName(String className) {
        if(className==null || className.isEmpty()){
            className = "%";
        }else{
            className = "%"+className+"%";
        }
        return classRepository.getClassesByName(className);
    }

    @Override
    public Classes insertClasses(Classes classes) {
        return classRepository.save(classes);
    }
}
