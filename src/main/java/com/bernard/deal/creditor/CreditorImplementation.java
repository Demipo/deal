package com.bernard.deal.creditor;

import com.bernard.deal.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CreditorImplementation implements CreditorService {

    @Autowired
    private CreditorRepository creditorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Creditor createCreditor(CreditorDto creditorDto) {
        Creditor creditor = modelMapper.map(creditorDto, Creditor.class);
        creditor.setCreditorId("");
        return creditorRepository.save(creditor);
    }

    @Override
    public Creditor updateCreditor(CreditorDto creditorDto, String creditorId) {
        if(creditorRepository.findByCreditorId(creditorId) != null){
            Creditor creditor = modelMapper.map(creditorDto, Creditor.class);
            return creditorRepository.save(creditor);
        }
        else{
            throw new ResourceNotFoundException("No such payment record");
        }
    }

    @Override
    public Creditor fetchCreditor(String creditorId) {
        Creditor creditor = creditorRepository.findByCreditorId(creditorId)
                .orElseThrow(() -> new ResourceNotFoundException("No such payment record"));
        return creditor;
    }

    @Override
    public Page<Creditor> fetchAllCreditor(Pageable pageable) {
        return creditorRepository.findAllCreditor(pageable);
    }

    @Override
    public Creditor deleteCreditor(String creditorId) {
        Creditor creditor = creditorRepository.findByCreditorId(creditorId)
                .orElseThrow(() -> new ResourceNotFoundException("No such payment record"));
        return creditor;
    }
}
