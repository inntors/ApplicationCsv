package com.smdev.applicationcsv.example;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String lastName;
    private String country;
    private String age;
}
