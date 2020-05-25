package com.itlize.codinghomework2.service;

import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CodingService {

    ResponseEntity<?> codingTestOne(String number);

    ResponseEntity<?> codingTestTwo(String path) throws IOException;

    ResponseEntity<?> codingTestThree(String path) throws IOException;

    ResponseEntity<?> codingTestFour(String path) throws IOException;

    ResponseEntity<?> codingTestFive(String path) throws IOException;
}
