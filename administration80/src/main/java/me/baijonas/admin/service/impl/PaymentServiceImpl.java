package me.baijonas.admin.service.impl;

import me.baijonas.admin.service.IPaymentService;
import me.baijonas.commons.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private RestTemplate template;
    @Value("${payment.url}")
    private String PAYMENT_URL;
    @Override
    public List<Payment> getAllPaymentsInfo() {
        return template.getForObject(PAYMENT_URL + "/payment", List.class);
    }
}
