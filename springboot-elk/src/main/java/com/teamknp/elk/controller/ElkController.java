package com.teamknp.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ElkController {

    @ResponseBody
    @GetMapping(value = "/members/{id}")
    public ResponseEntity<?> getMember(@PathVariable("id") Long id) {
        log.info("GET getMember inside id:" + id);
        String response = "Hello, Member " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        log.info("GET getMember response : {}", response);
        return ResponseEntity.ok(response);
    }
}
