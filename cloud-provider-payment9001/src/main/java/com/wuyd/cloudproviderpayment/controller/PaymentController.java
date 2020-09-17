package com.wuyd.cloudproviderpayment.controller;


import com.wuyd.cloudproviderpayment.aop.Log;
import com.wuyd.cloudproviderpayment.dto.CommonResult;
import com.wuyd.cloudproviderpayment.entity.PaymentEntity;
import com.wuyd.cloudproviderpayment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Log("create")
    @PostMapping("payment")
    public ResponseEntity<CommonResult<Boolean>> create(@RequestBody PaymentEntity paymentEntity){
        if (paymentService.save(paymentEntity)) {
            return ResponseEntity.ok(new CommonResult<>(0, "success",Boolean.TRUE));
        }
        return ResponseEntity.ok(new CommonResult<>(1, "No",Boolean.FALSE));
    }

    @Log("getById")
    @GetMapping("payment/{id}")
    public ResponseEntity<PaymentEntity> getById(@PathVariable Long id){
        PaymentEntity paymentEntity = paymentService.getById(id);
        return ResponseEntity.ok(paymentEntity);
    }

}

