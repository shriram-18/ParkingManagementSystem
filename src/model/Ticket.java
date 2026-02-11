package model;

import java.time.LocalDateTime;
import service.pricing.PricingStrategy;


public class Ticket {

    private static int counter = 1;

    private int ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private PricingStrategy pricingStrategy;


    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot, PricingStrategy pricingStrategy) {
        this.ticketId = counter++;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
        this.pricingStrategy = pricingStrategy;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
    }

    public double calculateAmount() {
        if (exitTime == null) {
            throw new RuntimeException("Vehicle has not exited yet!");
        }
        return pricingStrategy.calculateAmount(entryTime, exitTime);
    }
}
