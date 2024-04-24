package ooad.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ooad.demo.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
    // You can define additional methods here if needed
}