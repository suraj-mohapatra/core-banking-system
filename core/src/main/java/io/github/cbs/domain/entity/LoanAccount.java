package io.github.cbs.domain.entity;

import io.github.cbs.domain.behaviour.Depositable;
import lombok.Data;

@Data
public class LoanAccount implements Depositable {
    /**
     * @param amount
     */
    @Override
    public void deposit(double amount) {

    }
}
