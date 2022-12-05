package com.api.spring_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(length = 100, nullable = false)
    public String name;
    
    @Column(length = 100, nullable = false)
    public String email;
    
    @Column(length = 100, nullable = false)
    public String password; 
    
}
