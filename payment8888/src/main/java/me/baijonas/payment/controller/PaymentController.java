package me.baijonas.payment.controller;

import me.baijonas.commons.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private Map<String, Payment> payments;

    @PostConstruct
    public void initialize() {
        payments = new ConcurrentHashMap<>();
        payments.put("1", Payment.builder().id("1").amount(100.0).merchant("Apple").customer("Jonas").date("2020-03-18").build());
        payments.put("2", Payment.builder().id("2").amount(110.0).merchant("Microsoft").customer("Jay").date("2020-03-18").build());
        payments.put("3", Payment.builder().id("3").amount(157.8).merchant("Google").customer("Yukui").date("2020-03-18").build());
        payments.put("4", Payment.builder().id("4").amount(232.9).merchant("Amazon").customer("Yajuan").date("2020-03-18").build());
        payments.put("5", Payment.builder().id("5").amount(568.7).merchant("Apple").customer("Diandian").date("2020-03-18").build());
    }

    @GetMapping
    public ResponseEntity getAllPaymentsInfo() {
        List<Payment> pays = payments.values().stream()
                .collect(Collectors.toList());

        return new ResponseEntity(pays,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> getPaymenyInfo(@PathVariable String id) {
        Payment p = payments.getOrDefault(id,null);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Payment> pay(@RequestBody Payment payment) {
        if (payments.containsKey(payment.getId())) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            payments.put(payment.getId(),payment);
            return new ResponseEntity<>(payment,HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Payment> modifyPayment(@PathVariable String id,@RequestBody Payment payment) {
        if (!payments.containsKey(id) || !id.equals(payment.getId())) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            payments.put(payment.getId(),payment);
            return new ResponseEntity<>(payment,HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Payment> modifyPayment(@PathVariable String id) {
        if (!payments.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            payments.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/exception")
    public void triggerException() {
        int val = 5/0;
    }

    @ExceptionHandler
    public ResponseEntity handleExcepion(Exception e) {
        return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
