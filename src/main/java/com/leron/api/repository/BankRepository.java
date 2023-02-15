package com.leron.api.repository;

import com.leron.api.model.entities.BankEntity;
import com.leron.api.model.entities.BankTransitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long> {
}
