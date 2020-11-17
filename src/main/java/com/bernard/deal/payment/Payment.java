package com.bernard.deal.payment;

import com.bernard.deal.creditor.AuditModel;
import com.bernard.deal.creditor.Creditor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Payment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Amount should not be blank")
    @Column(nullable = false, unique = true)
    private double creditedAmount;
    private String paymentId;
    @ManyToOne
    private Creditor creditor;

}
