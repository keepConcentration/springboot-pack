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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ElkController {

    private final ElkService elkService;

    @ResponseBody
    @GetMapping(value = "/hellos/{id}")
    public ResponseEntity<?> getHello(@PathVariable("id") final Long id) {
        log.info("GET getHello inside id:" + id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(elkService.searchHello(id));
        String response = "Hello,  " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        log.info("GET getHello response : {}", response);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping(value = "/hellos")
    public ResponseEntity<?> insertHello(@RequestBody HelloDto helloDto) {
        final Long id = elkService.insertHello(helloDto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
