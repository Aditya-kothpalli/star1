package com.example.demo.cont;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Number;
import com.example.demo.service.NumberService;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    // Create a new number (POST)
    @PostMapping
    public ResponseEntity<String> createNumber(@RequestBody Number number) {
        String response = numberService.createNumber(number);
        return ResponseEntity.ok(response);
    }

    // Retrieve a number by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Number> getNumber(@PathVariable int id) {
        if (!numberService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(numberService.getNumberById(id));
    }

    // Retrieve all numbers (GET)
    @GetMapping
    public ResponseEntity<List<Number>> getAllNumbers() {
        List<Number> numbers = numberService.getAllNumbers();
        return ResponseEntity.ok(numbers);
    }

    // Update a number by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNumber(@PathVariable int id, @RequestBody Number updatedNumber) {
        if (!numberService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Number not found!");
        }
        String response = numberService.updateNumber(id, updatedNumber);
        return ResponseEntity.ok(response);
    }

    // Delete a number by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNumber(@PathVariable int id) {
        if (!numberService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Number not found!");
        }
        String response = numberService.deleteNumber(id);
        return ResponseEntity.ok(response);
    }
}