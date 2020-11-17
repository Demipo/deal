package com.bernard.deal.payment;

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
@RequestMapping("/payment")
public class PaymentApi {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<Payment>> createPayment(@Valid @RequestBody PaymentDto paymentDto){
            ApiResponse<Payment>  apiResponse = new ApiResponse<>(HttpStatus.OK);
            Payment payment = paymentService.createPayment(paymentDto);
            apiResponse.setPayload(payment);
            apiResponse.setMessage("Payment was created successfully");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/paymentId", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse<Payment>> updatePayment(@PathVariable String paymentId,
                                                              @Valid @RequestBody PaymentDto paymentDto){
        ApiResponse<Payment> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Payment payment = paymentService.updatePayment(paymentDto, paymentId);
        apiResponse.setPayload(payment);
        apiResponse.setMessage("Payment was updated successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentId", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Payment>> fetchPayment(@PathVariable String paymentId){
        ApiResponse<Payment> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Payment payment = paymentService.fetchPayment(paymentId);
        apiResponse.setPayload(payment);
        apiResponse.setMessage("Payment fetched successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Page<Payment>>> fetchAllPayments(Pageable pageable){
        ApiResponse<Page<Payment>> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Page<Payment> payment = paymentService.fetchAllPayment(pageable);
        apiResponse.setPayload(payment);
        apiResponse.setMessage("Payments fetched successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/creditorId", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Page<Payment>>> fetchPaymentByCreditorId(@PathVariable String creditorId, Pageable pageable){
        ApiResponse<Page<Payment>> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Page<Payment> payment = paymentService.fetchPaymentByCreditorId(creditorId, pageable);
        apiResponse.setPayload(payment);
        apiResponse.setMessage("Payments fetched successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/paymentId", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse<Payment>> deletePayment(@PathVariable String paymentId){
        ApiResponse<Payment> apiResponse = new ApiResponse<>(HttpStatus.OK);
        Payment payment = paymentService.deletePayment(paymentId);
        apiResponse.setPayload(payment);
        apiResponse.setMessage("Payment deleted successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
