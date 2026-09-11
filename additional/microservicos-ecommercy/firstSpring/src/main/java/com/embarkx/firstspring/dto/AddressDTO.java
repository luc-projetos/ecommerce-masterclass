package com.embarkx.firstspring.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String id;
    private String street;
    private String zipcode;
    private String city;
    private String state;
    private String country;
}
