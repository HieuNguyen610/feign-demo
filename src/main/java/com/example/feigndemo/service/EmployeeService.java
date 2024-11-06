package com.example.feigndemo.service;

import com.example.feigndemo.model.Employee;
import com.example.feigndemo.repository.EmployeeRepo;
import com.example.feigndemo.response.AddressResponse;
import com.example.feigndemo.response.EmployeeResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private ModelMapper mapper;
    private final AddressClient addressClient;

    public EmployeeResponse getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressById(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }
}
