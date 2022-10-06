package com.teamknp.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ElkController {

    @GetMapping(value = "/members")
    public String getMember(@PathVariable Long id) {
        log.info("GET getMember inside");
        String response = "Hello, Member " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        log.info("GET getMember response : {}", response);
        return response;
    }
}
