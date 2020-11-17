package com.bernard.deal.payment;

import com.bernard.deal.payment.Payment;
import com.bernard.deal.payment.PaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {
    Payment createPayment(PaymentDto paymentDto);

    Payment updatePayment(PaymentDto paymentDto, String paymentId);

    Payment fetchPayment(String paymentId);

    Page<Payment> fetchAllPayment(Pageable pageable);

    Page<Payment> fetchPaymentByCreditorId(String creditorId, Pageable pageable);

    Payment deletePayment(String paymentId);
}



