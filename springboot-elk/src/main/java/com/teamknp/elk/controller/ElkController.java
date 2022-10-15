package com.teamknp.elk.controller;

import com.teamknp.elk.domain.HelloDto;
import com.teamknp.elk.domain.ResponseDto;
import com.teamknp.elk.repository.Hello;
import com.teamknp.elk.service.ElkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ElkController {

    private final RestTemplate restTemplate;

    private final ElkService elkService;

    @GetMapping(value = "elk")
    @ResponseBody
    public ResponseEntity<?> hello() {
        String response = "Hello Elk! " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
