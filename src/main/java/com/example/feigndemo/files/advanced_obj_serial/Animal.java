package com.example.feigndemo.files.advanced_obj_serial;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable {
    private final long serialVersionUID = 2L;

    private String name;
    private Double weight;
}
