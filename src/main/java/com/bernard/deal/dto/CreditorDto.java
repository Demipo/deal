package com.bernard.deal.dto;

import com.bernard.deal.domain.InstallmentPeriod;
import com.bernard.deal.domain.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class CreditorDto {
    private String firstName;
    private String lastName;
    private String dealDescription;
    private ZonedDateTime startDate;
    private double totalAmount;
    private PaymentType paymentType;
    private InstallmentPeriod period;
}
