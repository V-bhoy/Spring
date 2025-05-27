package com.service;

import com.entity.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    public String registerCar(Car car) {
        return "CAR-" + System.currentTimeMillis();
    }
}
