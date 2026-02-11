package main;

import model.Car;
import model.Bike;
import service.ParkingLot;

public class Main {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(5, 20.0);

        try {

            // ---- Park Car ----
            Car car = new Car("MH12CAR1234");
            var carTicket = parkingLot.parkVehicle(car);

            // ---- Park Bike ----
            Bike bike = new Bike("MH14BIKE5678");
            var bikeTicket = parkingLot.parkVehicle(bike);

            // Simulate parking duration
            Thread.sleep(2000);

            // ---- Remove Vehicles ----
            double carAmount = parkingLot.removeVehicle(carTicket.getTicketId());
            double bikeAmount = parkingLot.removeVehicle(bikeTicket.getTicketId());

            System.out.println("Car Amount: " + carAmount);
            System.out.println("Bike Amount: " + bikeAmount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
