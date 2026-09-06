package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.GLAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GLAccountRepository extends JpaRepository<GLAccount, Long> {
}
