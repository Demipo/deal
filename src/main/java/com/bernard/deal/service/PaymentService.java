package com.bernard.deal.service;

import com.bernard.deal.domain.Payment;
import com.bernard.deal.dto.PaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDto paymentDto);

    Payment updatePayment(PaymentDto paymentDto, String paymentId);

    Payment fetchPayment(String paymentId);

    Page<Payment> fetchAllPayment(Pageable pageable);

    Page<Payment> fetchPaymentByCreditorId(String creditorId, Pageable pageable);

    Payment deletePayment(String paymentId);
}



