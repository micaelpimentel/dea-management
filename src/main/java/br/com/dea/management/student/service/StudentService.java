package br.com.dea.management.student.service;

import br.com.dea.management.exceptions.NotFoundExceptions;
import br.com.dea.management.student.domain.Student;
import br.com.dea.management.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    public Page<Student> findAllStudentsPaginated(Integer page, Integer pageSize) {
        return this.studentRepository.findAllPaginated(PageRequest.of(page, pageSize));
    }

    public Student findStudentById(Integer id) {
        Optional<Student> student = this.studentRepository.findById(Long.valueOf(id));

        if (student.isPresent()) {
            return student.get();
        }

        throw new NotFoundExceptions(Student.class, id);
    }
}
