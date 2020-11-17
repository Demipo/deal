package com.bernard.deal.creditor;

import com.bernard.deal.creditor.AuditModel;
import com.bernard.deal.payment.InstallmentPeriod;
import com.bernard.deal.payment.PaymentType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
public class Creditor extends AuditModel {
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
