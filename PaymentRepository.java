package ooad.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ooad.demo.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can define custom query methods here if needed
}
