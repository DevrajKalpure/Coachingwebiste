package com.example.coaching.controller;

import com.example.coaching.model.Enquiry;
import com.example.coaching.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enquiries")
//@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to connect
@CrossOrigin(origins = "http://coachingfrontend-tau.vercel.app") // Allow frontend to connect
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @PostMapping
    public Enquiry createEnquiry(@RequestBody Enquiry enquiry) {
        return enquiryService.saveEnquiry(enquiry);
    }
}