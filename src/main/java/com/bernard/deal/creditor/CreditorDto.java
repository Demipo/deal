package com.bernard.deal.creditor;

import com.bernard.deal.payment.InstallmentPeriod;
import com.bernard.deal.payment.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditorDto {
    private String firstName;
    private String lastName;
    private String dealDescription;
    private double totalAmount;
    private PaymentType paymentType;
    private InstallmentPeriod period;
}
