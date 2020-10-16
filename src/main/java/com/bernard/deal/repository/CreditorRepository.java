package com.bernard.deal.repository;

import com.bernard.deal.domain.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditorRepository extends JpaRepository<Creditor, Long> {

    Optional<Creditor> findAllByCreditorId(String creditorId);
}
