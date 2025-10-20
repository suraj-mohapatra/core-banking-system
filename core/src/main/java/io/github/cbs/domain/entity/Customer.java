package io.github.cbs.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "customer", schema = "core")
@Data
public class Customer implements Serializable {
    // I know I am gonna use jackson for json serialization. but still as of now keeping Serializable
    // implemented as it can be helpful in session persistence. I may remove it in future.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String country;

}
