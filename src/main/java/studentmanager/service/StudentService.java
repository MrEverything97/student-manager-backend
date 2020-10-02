package studentmanager.service;

import studentmanager.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Iterable<Student> findAll();
//    Optional<Student> findById(Long id);
   void saveAll(List<Student> studentList);
  void deleteAll();
//    List<Student> findByName(String name);
}
