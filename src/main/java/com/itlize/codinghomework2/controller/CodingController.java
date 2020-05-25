package com.itlize.codinghomework2.controller;

import com.itlize.codinghomework2.service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/coding2")
public class CodingController {

    @Autowired
    CodingService codingService;

    @GetMapping(value = "/testone")
    public ResponseEntity testOne(@RequestParam String number) {
        return codingService.codingTestOne(number);
    }

    @GetMapping(value = "/testtwo")
    public ResponseEntity testTwo(@RequestParam String path) throws IOException {
        return codingService.codingTestTwo(path);
    }

    @GetMapping(value = "/testthree")
    public ResponseEntity testThree(@RequestParam String path) throws IOException {
        return codingService.codingTestThree(path);
    }

    @GetMapping(value = "/testfour")
    public ResponseEntity testFour(@RequestParam String path) throws IOException {
        return codingService.codingTestFour(path);
    }

    @GetMapping(value = "/testfive")
    public ResponseEntity testFive(@RequestParam String path) throws IOException {
        return codingService.codingTestFive(path);
    }
}
