package me.baijonas.admin.controller;

import me.baijonas.admin.service.IPaymentService;
import me.baijonas.commons.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IPaymentService service;

    @GetMapping(value = "/payment")
    public ResponseEntity getAllPaymentsInfo() {
        List<Payment> pays = service.getAllPaymentsInfo();
        return new ResponseEntity(pays, HttpStatus.OK);
    }
}
