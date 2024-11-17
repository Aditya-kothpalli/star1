package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Number;

@Service
	public class NumberService {

	    private final Map<Integer, Number> numberMap = new HashMap<>();
	    private int currentId = 1;

	    // Create a new number
	    public String createNumber(Number number) {
	        number.setId(currentId++);
	        numberMap.put(number.getId(), number);
	        return "Number added with ID: " + number.getId();
	    }

	    // Retrieve a number by ID
	    public Number getNumberById(int id) {
	        return numberMap.get(id);
	    }

	    // Retrieve all numbers
	    public List<Number> getAllNumbers() {
	        return new ArrayList<>(numberMap.values());
	    }

	    // Update a number by ID
	    public String updateNumber(int id, Number updatedNumber) {
	        if (!numberMap.containsKey(id)) {
	            return "Number not found!";
	        }
	        updatedNumber.setId(id);
	        numberMap.put(id, updatedNumber);
	        return "Number updated successfully!";
	    }

	    // Delete a number by ID
	    public String deleteNumber(int id) {
	        if (!numberMap.containsKey(id)) {
	            return "Number not found!";
	        }
	        numberMap.remove(id);
	        return "Number deleted successfully!";
	    }

	    // Check if a number exists
	    public boolean exists(int id) {
	        return numberMap.containsKey(id);
	    }
	}



