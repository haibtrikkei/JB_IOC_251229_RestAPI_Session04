package ra.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.demo.model.entity.Classes;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Classes, String> {
    List<Classes> findAllByClassNameContainingAndStatus(String className, Boolean status);

    //Sử dụng JQPL
    @Query("select c from Classes c where c.className like :className")
    List<Classes> getClassesByName(String className);
}
