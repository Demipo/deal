package com.bernard.deal.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double creditedAmount;
    private ZonedDateTime creditedDate;
    private ZonedDateTime updatedDate;
    private String paymentId;
    @ManyToOne
    private Creditor creditor;

}
