package com.example.coaching.controller;

import com.example.coaching.model.Enquiry;
import com.example.coaching.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/enquiries")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to connect
public class AdminEnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    // Endpoint to get all enquiries
    @GetMapping
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    // Endpoint to toggle the 'clarified' status of an enquiry
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Enquiry> toggleEnquiryStatus(@PathVariable Long id) {
        return enquiryRepository.findById(id)
            .map(enquiry -> {
                enquiry.setClarified(!enquiry.isClarified());
                Enquiry updatedEnquiry = enquiryRepository.save(enquiry);
                return ResponseEntity.ok(updatedEnquiry);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}