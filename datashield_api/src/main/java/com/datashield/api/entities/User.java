package com.datashield.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Table(name = "\"user\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(length = 254, unique = true)
    private String email;
    private String phone;
    private Date dateOfBirth;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;



}
