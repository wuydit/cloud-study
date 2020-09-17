package com.wuyd.cloudproviderpayment.controller;


import com.wuyd.cloudproviderpayment.dto.CommonResult;
import com.wuyd.cloudproviderpayment.entity.PaymentEntity;
import com.wuyd.cloudproviderpayment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuYd
 * @since 2020-09-17
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("payment")
    public ResponseEntity<CommonResult<Boolean>> create(@RequestBody PaymentEntity paymentEntity){
        if (paymentService.save(paymentEntity)) {
            return ResponseEntity.ok(new CommonResult<>(0, "success",Boolean.TRUE));
        }
        return ResponseEntity.ok(new CommonResult<>(1, "No",Boolean.FALSE));
    }

    @GetMapping("payment/{id}")
    public ResponseEntity<CommonResult<PaymentEntity>> create(@PathVariable Long id){
        PaymentEntity paymentEntity = paymentService.getById(id);
        if (paymentEntity != null) {
            return ResponseEntity.ok(new CommonResult<>(0, "success",paymentEntity));
        }
        return ResponseEntity.ok(new CommonResult<>(1, "No"));
    }

}

