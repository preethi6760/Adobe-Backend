package com.example.integerromanconversion.controller;

import com.example.integerromanconversion.service.RomanNumeralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost")
public class RomanNumeralController {

    private final RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    @GetMapping("/romannumeral")
    public ResponseEntity<Object> getRomanNumeral(@RequestParam("query") int query) {
        try {
            String roman = romanNumeralService.convertToRoman(query);
            return ResponseEntity.ok().body(new RomanNumeralResponse(String.valueOf(query), roman));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: Input must be a whole number between 1 and 3999.");
        }
    }

    static class RomanNumeralResponse {
        private String input;
        private String output;

        public RomanNumeralResponse(String input, String output) {
            this.input = input;
            this.output = output;
        }

        public String getInput() {
            return input;
        }

        public String getOutput() {
            return output;
        }
    }
}
