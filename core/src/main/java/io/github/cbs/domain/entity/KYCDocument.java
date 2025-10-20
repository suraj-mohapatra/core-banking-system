package io.github.cbs.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="kyc_document",schema="core")
public class KYCDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

}
