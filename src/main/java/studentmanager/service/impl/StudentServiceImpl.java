package studentmanager.service.impl;

import studentmanager.model.Student;
import studentmanager.repository.StudentRepository;
import studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void saveAll(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

//    @Override
//    public Optional<Student> findById(Long id) {
//        return studentRepository.findById(id);
//    }
//
//    @Override
//    public void save(Student student) {
//        studentRepository.save(student);
//    }
//
//    @Override
//    public void delete(Long id) {
//        studentRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Student> findByName(String name) {
//        return studentRepository.findByNameContaining(name);
//    }
}
