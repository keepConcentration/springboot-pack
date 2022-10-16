package com.teamknp.elk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping(value = "/elk")
@RequiredArgsConstructor
public class ElkController {

    // private final RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    @ResponseBody
    public ResponseEntity<?> hello() {
        String response = "Hello Elk! " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/exception")
    @ResponseBody
    public ResponseEntity<?> exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured.");
        } catch (Exception e) {
            e.printStackTrace();
            String stackTrace = ExceptionUtils.getStackTrace(e);
            log.error("Exception: " + stackTrace);
            response = stackTrace;
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
