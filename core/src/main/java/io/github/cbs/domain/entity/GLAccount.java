package io.github.cbs.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gl_account", schema="core")
public class GLAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private Double balance;
}
