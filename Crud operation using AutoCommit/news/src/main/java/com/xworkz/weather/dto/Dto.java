package com.xworkz.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dto {
    private int id;
    private String headline;
    private String source;
    private Timestamp Date;
    private String Category;
    private String Content;
}
