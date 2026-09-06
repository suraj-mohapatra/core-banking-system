package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.CustomerKyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerKycRepository extends JpaRepository<CustomerKyc, Long> {

    Optional<CustomerKyc> findByCustomerId(Long customerId);

    boolean existsByCustomerId(Long customerId);
}
