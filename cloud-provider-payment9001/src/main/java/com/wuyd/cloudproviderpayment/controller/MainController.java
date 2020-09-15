package com.wuyd.cloudproviderpayment.controller;


import com.wuyd.cloudproviderpayment.aop.Log;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author wuYd
 * @since 2020-09-07
 */
@RestController
@RequestMapping("/qnr")
public class MainController {


    /**
     * 问卷验证
     */
    @GetMapping("qnrVerification")
    @Log("问卷验证")
    public ResponseEntity<Boolean> qnrVerification(HttpServletRequest request,
                                                            @RequestParam("qnrId") Long qnrId) {
        return ResponseEntity.ok(Boolean.FALSE);
    }

}

