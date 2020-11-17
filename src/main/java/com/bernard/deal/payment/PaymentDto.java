package com.bernard.deal.payment;

import com.bernard.deal.creditor.Creditor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private double creditedAmount;
    private Creditor creditor;
}
