package com.bernard.deal.creditor;

import com.bernard.deal.creditor.Creditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditorRepository extends JpaRepository<Creditor, Long> {

    Optional<Creditor> findAllByCreditorId(String creditorId);

    Optional<Creditor> findByCreditorId(String creditorId);

    Page<Creditor> findAllCreditor(Pageable pageable);
}
