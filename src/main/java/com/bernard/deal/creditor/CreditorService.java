package com.bernard.deal.creditor;

import com.bernard.deal.creditor.Creditor;
import com.bernard.deal.creditor.CreditorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreditorService {
    Creditor createCreditor(CreditorDto creditorDto);

    Creditor updateCreditor(CreditorDto creditorDto, String creditorId);

    Creditor fetchCreditor(String paymentId);

    Page<Creditor> fetchAllCreditor(Pageable pageable);

    Creditor deleteCreditor(String creditorId);
}
