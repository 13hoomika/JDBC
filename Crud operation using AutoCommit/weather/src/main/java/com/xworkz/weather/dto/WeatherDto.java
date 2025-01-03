package com.xworkz.weather.dto;

import com.xworkz.weather.dao.WeatherDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherDto {
    private int id;
    private String city;
    private int temperature;
    private int humidity;
    private String weatherCondition;
    private String sunriseTime;
    private String sunsetTime;
    private boolean isActive;
}
