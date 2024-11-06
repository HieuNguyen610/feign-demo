package com.example.feigndemo.controller;

import com.example.feigndemo.response.EmployeeResponse;
import com.example.feigndemo.service.EmployeeService;
import com.example.feigndemo.service.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final ProductServiceClient productServiceClient;
    private final EmployeeService employeeService;

    @GetMapping("/fetchProducts")
    public ResponseEntity < ? > fetchProducts() {

        return ResponseEntity.ok(productServiceClient.getAllProducts());
    }

    @GetMapping("/fetchProduct/{id}")
    public ResponseEntity < ? > fetchProduct(@PathVariable int id) {

        return ResponseEntity.ok(productServiceClient.getProduct(id));
    }

    @GetMapping("/employee-service/employees/{id}")
    public ResponseEntity < ? > getEmployeeById(@PathVariable Long id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeResponse);
    }
}
