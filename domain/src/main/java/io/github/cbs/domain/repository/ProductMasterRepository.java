package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {
}
