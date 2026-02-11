package service;

import exception.ParkingFullException;
import exception.InvalidTicketException;
import model.*;
import java.util.ArrayList;
import java.util.List;
import service.pricing.*;


public class ParkingLot {

    private List<ParkingSpot> spots;
    private List<Ticket> activeTickets;

    public ParkingLot(int totalSpots, double hourlyRate) {
        spots = new ArrayList<>();
        activeTickets = new ArrayList<>();

        for (int i = 1; i <= totalSpots; i++) {
            double rate = hourlyRate;
            spots.add(new ParkingSpot(i, rate));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                if (vehicle.getVehicleType().equals("Bike")) {
                    spot = new ParkingSpot(spot.getSpotId(), 10.0);
                } else {
                    spot = new ParkingSpot(spot.getSpotId(), 20.0);
                }
                PricingStrategy strategy;

                if (vehicle.getVehicleType().equals("Bike")) {
                    strategy = new BikePricingStrategy();
                } else {
                    strategy = new CarPricingStrategy();
                }

                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle, spot, strategy);
                activeTickets.add(ticket);
                return ticket;
            }
        }

        throw new ParkingFullException("Parking Full!");
    }

    public double removeVehicle(int ticketId) {

        for (Ticket ticket : activeTickets) {
            if (ticket.getTicketId() == ticketId) {

                ticket.closeTicket();
                double amount = ticket.calculateAmount();

                ParkingSpot spot = ticket.getParkingSpot();
                spot.removeVehicle();

                activeTickets.remove(ticket);

                return amount;
            }
        }

        throw new InvalidTicketException("Invalid Ticket ID!");
    }

    public void showAvailableSpots() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                System.out.println("Spot " + spot.getSpotId() + " is available");
            }
        }
    }
}
