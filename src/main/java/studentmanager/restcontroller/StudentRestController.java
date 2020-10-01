package studentmanager.restcontroller;

import studentmanager.model.Student;
import studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> studentList;
        studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        } else {
            student.setName(student.getName());
            student.setStudentCode(student.getStudentCode());
            student.setDateOfBirth(student.getDateOfBirth());
            student.setPhoneNumber(student.getPhoneNumber());
            studentService.save(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        } else {
            studentService.delete(id);
            return new ResponseEntity<Student>(HttpStatus.OK);
        }
    }
}
