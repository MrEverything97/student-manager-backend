package studentmanager.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import studentmanager.model.Student;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Long> {
    List<Student> findByName(String name);
}
