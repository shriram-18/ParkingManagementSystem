# 🚗 Smart Parking Management System

## 📖 Project Overview

Smart Parking Management System is a modular backend simulation built using **Java and Object-Oriented Programming principles**.

This project models a real-world parking lot system with clean architecture, dynamic pricing strategy, and structured exception handling. The focus was to design a scalable and maintainable system rather than just building a simple console application.

---

## 🎯 Objectives

- Practice strong Object-Oriented Design
- Apply SOLID principles
- Implement Strategy Pattern for flexible pricing
- Build layered architecture
- Separate business logic from models
- Prepare foundation for JDBC integration

---

## 🏗 System Architecture

The system follows a layered structure:

```
Main (Driver Layer)
   ↓
ParkingLot (Service Layer)
   ↓
Ticket (Domain Model)
   ↓
PricingStrategy (Strategy Pattern)
   ↓
Vehicle & ParkingSpot (Core Entities)
```

Each class has a single responsibility to ensure clean separation of concerns.

---

## ✨ Features

- Park and remove vehicles (Car / Bike)
- Dynamic pricing using Strategy Pattern
- Hour-based billing calculation
- Multiple parking spot management
- Automatic ticket generation
- Custom exception handling:
  - ParkingFullException
  - InvalidTicketException
- Clean layered architecture

---

## 🧠 Design Concepts Used

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Strategy Pattern
- Open-Closed Principle
- Layered Architecture
- Custom Exceptions

---

## 💻 Technologies Used

- Java
- Java Collections Framework
- Java Time API (LocalDateTime, Duration)
- Exception Handling

---

## 📂 Project Structure

```
src
 ├── model
 │    ├── Vehicle.java
 │    ├── Car.java
 │    ├── Bike.java
 │    ├── ParkingSpot.java
 │    └── Ticket.java
 │
 ├── service
 │    ├── ParkingLot.java
 │    └── pricing
 │         ├── PricingStrategy.java
 │         ├── CarPricingStrategy.java
 │         └── BikePricingStrategy.java
 │
 ├── exception
 │    ├── ParkingFullException.java
 │    └── InvalidTicketException.java
 │
 └── main
      └── Main.java
```



## 🚀 How It Works

1. Vehicle enters parking lot.
2. ParkingLot assigns an available spot.
3. A Ticket is generated with entry time.
4. PricingStrategy calculates fee based on vehicle type.
5. On exit, ticket closes and total amount is computed.
6. Spot becomes available again.

---

## 🛠 How To Run

1. Clone the repository.
2. Open in IntelliJ IDEA (or any Java IDE).
3. Run `Main.java`.
4. View parking and billing simulation in console.

---

## 🔮 Future Enhancements

- JDBC integration with MySQL
- Database persistence for tickets and vehicles
- Revenue reporting module
- Multithreading support
- REST API version using Spring Boot

---

## 📌 Learning Outcome

This project was built to deeply understand backend system design using Java OOP rather than focusing on UI. It demonstrates clean architecture, modular thinking, and scalable design principles.
