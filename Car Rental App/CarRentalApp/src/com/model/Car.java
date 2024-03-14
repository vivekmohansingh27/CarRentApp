package com.model;
import java.io.*;
import java.util.*;

public class Car {
    private String id;
    private String car_name;
    private String model;
    private int year;

    public Car(String id, String car_name, String model, int year) {
        this.id = id;
        this.car_name = car_name;
        this.model = model;
        this.year = year;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

   
}
