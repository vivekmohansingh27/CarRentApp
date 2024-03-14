package com.service;
import java.io.*;
import java.util.*;

import com.model.Car;
import com.model.Customer;
import com.model.Rental;

 public class FileManager {
    
	private static final String CAR_FILE = "cars.txt";
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String RENTAL_FILE = "rentals.txt";

    public static void writeCars(List<Car> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_FILE))) {
            for (Car car : cars) {
                writer.println(car.getId() + "," + car.getCar_name() + "," + car.getModel() + "," + car.getYear());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAR_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Car car = new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                cars.add(car);
            }
        } catch (FileNotFoundException e) {
            
            createEmptyFile(CAR_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    

    private static void createEmptyFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    
    public static void writeCustomers(List<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE))) {
            for (Customer customer : customers) {
                writer.println(customer.getId() + "," + customer.getName() + "," + customer.getContact());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Customer customer = new Customer(parts[0], parts[1], parts[2]);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeRentals(List<Rental> rentals) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RENTAL_FILE))) {
            for (Rental rental : rentals) {
                writer.println(rental.getRentalId() + "," + rental.getCarId() + "," + rental.getCustomerId() + "," + rental.getDuration());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Rental> readRentals() {
        List<Rental> rentals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RENTAL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Rental rental = new Rental(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
                rentals.add(rental);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rentals;
    }

	
}