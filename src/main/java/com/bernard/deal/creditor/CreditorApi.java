package com.bernard.deal.creditor;

import com.bernard.deal.apiresponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class CreditorApi {

    @Autowired
    private CreditorService creditorService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<Creditor>> createCreditor(@Valid @RequestBody CreditorDto creditorDto){
        ApiResponse<Creditor>  apiResponse = new ApiResponse<>(HttpStatus.OK);
        Creditor creditor = creditorService.createCreditor(creditorDto);
        apiResponse.setPayload(creditor);
        apiResponse.setMessage("Creditor created successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/creditorId", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse<Creditor>> updateCreditor(@PathVariable String creditorId,
                                                              @Valid @RequestBody CreditorDto creditorDto){
        ApiResponse<Creditor> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Creditor creditor = creditorService.updateCreditor(creditorDto, creditorId);
        apiResponse.setPayload(creditor);
        apiResponse.setMessage("Creditor updated successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/creditorId", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Creditor>> fetchCreditor(@PathVariable String creditorId){
        ApiResponse<Creditor> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Creditor creditor = creditorService.fetchCreditor(creditorId);
        apiResponse.setPayload(creditor);
        apiResponse.setMessage("Creditor fetched successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Page<Creditor>>> fetchAllPayments(Pageable pageable){
        ApiResponse<Page<Creditor>> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Page<Creditor> creditor = creditorService.fetchAllCreditor(pageable);
        apiResponse.setPayload(creditor);
        apiResponse.setMessage("Creditor fetched successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/creditorId", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse<Creditor>> deletePayment(@PathVariable String creditorId){
        ApiResponse<Creditor> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Creditor creditor = creditorService.deleteCreditor(creditorId);
        apiResponse.setPayload(creditor);
        apiResponse.setMessage("Payment deleted successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
