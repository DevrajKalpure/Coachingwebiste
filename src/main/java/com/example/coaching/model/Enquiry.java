package com.example.coaching.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    private String courseTitle; // Store course title for email
    private String name;
    private String email;
    private String phoneNumber; // New optional field
    private String message;
    

    // This field requires the isClarified() and setClarified() methods
    private boolean clarified = false;
}