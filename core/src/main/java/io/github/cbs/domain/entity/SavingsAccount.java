package io.github.cbs.domain.entity;

import io.github.cbs.domain.behaviour.Depositable;
import io.github.cbs.domain.behaviour.Withdrawable;
import lombok.Data;

@Data
public class SavingsAccount implements Depositable, Withdrawable {




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
