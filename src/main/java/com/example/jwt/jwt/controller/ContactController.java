package com.example.jwt.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String getContactInquiryDetails() {
        return "Inquiry details are saved to the DB";
    }
}
