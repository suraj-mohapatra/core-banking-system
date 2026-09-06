package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.CustomerKycDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerKycDocumentRepository extends JpaRepository<CustomerKycDocument, Long> {

    List<CustomerKycDocument> findByCustomerKycId(Long customerKycId);
}