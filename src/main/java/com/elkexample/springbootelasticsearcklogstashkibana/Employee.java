package com.elkexample.springbootelasticsearcklogstashkibana;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;
    private String depaertment;
}
