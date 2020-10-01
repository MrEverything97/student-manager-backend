package studentmanager.service;

import studentmanager.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    void delete(Long id);
    List<Student> findByName(String name);
}
