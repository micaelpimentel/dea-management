package br.com.dea.management;

import br.com.dea.management.student.domain.Student;
import br.com.dea.management.student.repository.StudentRepository;
import br.com.dea.management.user.domain.User;
import br.com.dea.management.user.repository.UserRepository;
import br.com.dea.management.user.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DeamanagementApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeamanagementApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(String... args) throws Exception {
		//Deleting all Users
		this.userRepository.deleteAll();

		//Creating some students
		for (int i = 0; i < 100; i++) {
			User u = new User();
			u.setEmail("email " + i);
			u.setName("name " + i);
			u.setLinkedin("linkedin " + i);
			u.setPassword("pwd " + i);

			Student s = new Student();
			s.setUniversity("UNI " + i);
			s.setGraduation("Grad " + i);
			s.setFinishDate(LocalDate.now());
			s.setUser(u);

			this.studentRepository.save(s);
		}

		//Loading all Users
//		List<User> users = this.userService.findAllUsers();
//		users.forEach(u -> System.out.println("Name: " + u.getName()));

		//Loading by @Query
//		Optional<User> loadedUserByName = this.userRepository.findByName("name 1");
//		System.out.println("User name 1 (From @Query) name: " + loadedUserByName.get().getName());
//
//		TypedQuery<User> q = entityManager.createNamedQuery("myQuery", User.class);
//		q.setParameter("name", "name 2");
//		User userFromNamedQuery = q.getResultList().get(0);
//		System.out.println("User name 2 (From NamedQuery) name: " + userFromNamedQuery.getName());

		//Loading user by emailUser loadedUser = this.userService.findUserByEmail("email 1");
		////		System.out.println("User email 1 name: " + loadedUser.getName());
//

	}
}
