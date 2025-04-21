package com.example.jwt.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cardsController {

    @GetMapping("/myCards")
    public String getCardsDetails() {
        return "Here are the CATD details from the DB";
    }
}
