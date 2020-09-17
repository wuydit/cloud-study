package org.wuyd.cloudconsumerorder9002.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.wuyd.cloudconsumerorder9002.dto.CommonResult;
import org.wuyd.cloudconsumerorder9002.entity.PaymentEntity;

/**
 * @author wuYd
 * 2020/9/17 17:41
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@AllArgsConstructor
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:9001";

    private final RestTemplate restTemplate;

    @GetMapping("payment")
    public ResponseEntity<CommonResult<PaymentEntity>> payment(PaymentEntity paymentEntity){
        return ResponseEntity.ok(new CommonResult<>(0, "OK",
                restTemplate.postForObject(PAYMENT_URL + "/payment", paymentEntity, PaymentEntity.class)));
    }


    @GetMapping("payment/{id}")
    public ResponseEntity<CommonResult<PaymentEntity>> createOrder(@PathVariable Long id){
        return ResponseEntity.ok(new CommonResult<>(0, "OK",
                restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, PaymentEntity.class)));
    }
}
