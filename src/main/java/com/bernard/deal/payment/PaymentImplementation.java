package com.bernard.deal.payment;

import com.bernard.deal.exception.ResourceNotFoundException;
import com.bernard.deal.creditor.CreditorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentImplementation implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CreditorRepository creditorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Payment createPayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        payment.setPaymentId("");
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(PaymentDto paymentDto, String paymentId) {
        if(paymentRepository.findByPaymentId(paymentId) != null){
            Payment payment = modelMapper.map(paymentDto, Payment.class);
            return paymentRepository.save(payment);
        }
        else{
            throw new ResourceNotFoundException("No such payment record");
        }
    }

    @Override
    public Payment fetchPayment(String paymentId) {
      Payment payment = paymentRepository.findByPaymentId(paymentId)
              .orElseThrow(() -> new ResourceNotFoundException("No such payment record"));
      return payment;
    }

    @Override
    public Page<Payment> fetchAllPayment(Pageable pageable){

        return paymentRepository.findAllPayments(pageable);
    }

    @Override
    public Page<Payment> fetchPaymentByCreditorId(String creditorId, Pageable pageable) {
        creditorRepository.findAllByCreditorId(creditorId)
                .orElseThrow(() -> new ResourceNotFoundException("No such creditor record"));
        return paymentRepository.findAllByCreditor_CreditorId(creditorId, pageable);
    }

    @Override
    public Payment deletePayment(String paymentId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("No such payment record"));
        return payment;
    }

}
