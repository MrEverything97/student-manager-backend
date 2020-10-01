package studentmanager.service;

import studentmanager.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    void delete(Long id);
}
