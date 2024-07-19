package com.datashield.api.entities;

import jakarta.persistence.*;

@Entity @Table(name = "\"service\"")
public class Service {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
}
