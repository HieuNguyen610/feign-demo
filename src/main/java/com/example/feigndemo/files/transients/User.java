package com.example.feigndemo.files.transients;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User implements Serializable {
    private final long serialVersionUID = 1L;
    private String name;
    private transient String password;


}
