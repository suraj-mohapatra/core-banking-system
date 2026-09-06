package io.github.cbs.domain.repository;

import io.github.cbs.domain.entity.KycDocumentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycDocumentMasterRepository extends JpaRepository<KycDocumentMaster, Integer> {

    Optional<KycDocumentMaster> findByDocumentCode(String documentCode);
}