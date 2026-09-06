package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.DepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositAccountRepository extends JpaRepository<DepositAccount, Long> {
}
