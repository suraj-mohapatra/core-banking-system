package io.github.cbs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.cbs.domain.entity.BranchMaster;

@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long> {
}
