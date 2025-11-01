package io.github.cbs.domain.entity;

import io.github.cbs.domain.behaviour.Depositable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class LoanAccount implements Depositable {
    @Id
    private Long id;

    /**
     * @param amount
     */
    @Override
    public void deposit(double amount) {

    }
}
