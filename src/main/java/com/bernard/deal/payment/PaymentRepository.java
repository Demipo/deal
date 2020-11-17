package com.bernard.deal.payment;

import com.bernard.deal.payment.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByPaymentId(String paymentId);

    Page<Payment> findAllPayments(Pageable pageable);

    Page<Payment> findAllByCreditor_CreditorId(String creditorId, Pageable pageable);
}
