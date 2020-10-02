package studentmanager.service;

import studentmanager.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    void deleteAll();

    List<Student> findByName(String name);
    Optional<Student> findById(Long id);
    void delete(Long id);
}
