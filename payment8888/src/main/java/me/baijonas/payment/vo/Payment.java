package me.baijonas.payment.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private String id;
    private double amount;
    private String merchant;
    private String customer;
    private String date;
}
