package com.ecommerceProjects.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private UserRole role;

    @Column(columnDefinition = "longblob")
    @Lob
    private byte[] avatar;
}
