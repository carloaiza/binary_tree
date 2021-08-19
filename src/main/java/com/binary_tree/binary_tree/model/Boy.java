package com.binary_tree.binary_tree.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Boy {

    private int identification;
    @NotNull
    private String name;
    private byte age;
    private String city;

}
