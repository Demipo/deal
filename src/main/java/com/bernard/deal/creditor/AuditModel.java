package com.bernard.deal.creditor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AuditModel {

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime startDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private ZonedDateTime updatedDate;

    private ZonedDateTime deletedAt = null;
}
