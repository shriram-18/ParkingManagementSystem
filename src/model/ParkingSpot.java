package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingSpot {

    private int spotId;
    private boolean isOccupied;
    private Vehicle vehicle;
    private double hourlyRate;

    public ParkingSpot(int spotId, double hourlyRate) {
        this.spotId = spotId;
        this.hourlyRate = hourlyRate;
        this.isOccupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        if (isOccupied) {
            throw new RuntimeException("Spot already occupied!");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        if (hours == 0) hours = 1; // minimum 1 hour
        return hours * hourlyRate;
    }
}
