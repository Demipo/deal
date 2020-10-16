package com.bernard.deal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
public class Creditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String dealDescription;
    private String creditorId;
    private ZonedDateTime startDate;
    private double totalAmount;
    private PaymentType paymentType;
    private InstallmentPeriod period;
}
