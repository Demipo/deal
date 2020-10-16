package com.bernard.deal.dto;

import com.bernard.deal.domain.Creditor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class PaymentDto {
    private double creditedAmount;
    private Creditor creditor;
}
