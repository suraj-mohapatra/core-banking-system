package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Customer> findByEmail(String email);

    boolean existsByCifNumber(String cifNumber);

    Optional<Customer> findByCifNumber(String cifNumber);
}
