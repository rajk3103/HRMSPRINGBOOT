package com.fullstack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //oracle we use SEQUENCE

    private int custId;

    private String custName;

    private String custAddress;

    @Column(unique = true)
    private long custContactNumber;

    @Column(unique = true)
    private String custEmail;

    private String custPassword;

    private double custAccountBalance;

    @JsonFormat (pattern = "dd-MM-yyyy")
    private Date custDOB;



}
