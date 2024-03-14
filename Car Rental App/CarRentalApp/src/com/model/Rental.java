package com.model;
import java.io.*;
import java.util.*;



public class Rental {
	
	
    private int rentalId;
    private String carId;
    private String customerId;
    private int duration;

    public Rental(int rentalId, String carId, String customerId, int duration) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerId = customerId;
        this.duration = duration;
    }

    

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
