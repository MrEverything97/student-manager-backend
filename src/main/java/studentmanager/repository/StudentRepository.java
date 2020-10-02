package studentmanager.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import studentmanager.model.Student;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findAllByOrderById();
    Optional<Student> findById(Long id);
}
