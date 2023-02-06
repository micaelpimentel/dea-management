package br.com.dea.management.student.service;

import br.com.dea.management.exceptions.NotFoundExceptions;
import br.com.dea.management.student.domain.Student;
import br.com.dea.management.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return this.studentRepository.findAllPaginated(PageRequest.of(page, pageSize,
                Sort.by("user.name").ascending()));
    }

    public Student findStudentById(Integer id) {
        return this.studentRepository.findById(Long.valueOf(id)).orElseThrow(() -> new NotFoundExceptions(Student.class, id));
    }
}
