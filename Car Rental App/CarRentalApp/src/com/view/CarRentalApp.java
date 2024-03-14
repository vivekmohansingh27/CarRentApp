package com.view;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;

import com.model.Car;
import com.model.Customer;
import com.model.Rental;
import com.service.FileManager;

public class CarRentalApp {
    private static Scanner scanner = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    public static void main(String[] args) {
        List<Car> cars = FileManager.readCars();
        List<Customer> customers = FileManager.readCustomers();
        List<Rental> rentals = FileManager.readRentals();

        while (true) {
            System.out.println("1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Add Customer");
            System.out.println("4. View Customers");
            System.out.println("5. Rent Car");
            System.out.println("6. View Rentals");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addCar(cars);
                    break;
                case 2:
                    viewCars(cars);
                    break;
                case 3:
                    addCustomer(customers);
                    break;
                case 4:
                    viewCustomers(customers);
                    break;
                case 5:
                    rentCar(cars, customers, rentals);
                    break;
                case 6:
                    viewRentals(rentals);
                    break;
                case 7:
                    FileManager.writeCars(cars);
                    FileManager.writeCustomers(customers);
                    FileManager.writeRentals(rentals);
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCar(List<Car> cars) {
        System.out.print("Enter car ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter car make: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  

        Car car = new Car(id, make, model, year);
        cars.add(car);
        System.out.println("Car added successfully.");
    }

    private static void viewCars(List<Car> cars) {
        System.out.println("Cars:");
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() + ", Make: " + car.getCar_name() + ", Model: " + car.getModel() + ", Year: " + car.getYear());
        }
    }

    private static void addCustomer(List<Customer> customers) {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer contact: ");
        String contact = scanner.nextLine();

        Customer customer = new Customer(id, name, contact);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    private static void viewCustomers(List<Customer> customers) {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Contact: " + customer.getContact());
        }
    }

    private static void rentCar(List<Car> cars, List<Customer> customers, List<Rental> rentals) {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter car ID: ");
        String carId = scanner.nextLine();
        System.out.print("Enter duration of rental (in days): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); 

        Rental rental = new Rental(random.nextInt(), carId, customerId, duration);
        rentals.add(rental);
        System.out.println("Car rented successfully.");
    }

    private static void viewRentals(List<Rental> rentals) {
        System.out.println("Rentals:");
        for (Rental rental : rentals) {
            System.out.println("Rental ID: " + rental.getRentalId() + ", Car ID: " + rental.getCarId() + ", Customer ID: " + rental.getCustomerId() + ", Duration: " + rental.getDuration() + " days");
        }
    }


}
