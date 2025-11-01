package io.github.cbs.domain.entity;

import io.github.cbs.domain.behaviour.Depositable;
import io.github.cbs.domain.behaviour.Withdrawable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class SavingsAccount implements Depositable, Withdrawable {

    @Id
    private Long id;

    private String accountNumber;

    /**
     * @param amount
     */
    @Override
    public void withdraw(double amount) {

    }

    /**
     * @param amount
     */
    @Override
    public void deposit(double amount) {

    }
}
