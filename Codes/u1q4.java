/*
4. A Vehicle Rental System manages different types of vehicles such as Car and Bike.
All vehicles have vehicleNumber and rentPerDay. Write a Java program using inheritance where:
●	Vehicle is a base class
●	Car and Bike are derived classes
●	Rent is calculated and displayed for each type
*/
class Vehicle {
    String vehicleNumber;
    int rentPerDay;

    Vehicle(String vehicleNumber, int rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    int calculateRent(int days) {
        return rentPerDay * days;
    }

    void display(int days) {
        System.out.println(vehicleNumber + " " + calculateRent(days));
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, int rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    void display(int days) {
        super.display(days);
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, int rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    void display(int days) {
        super.display(days);
    }
}

public class u1q4 {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C101", 2000);
        Vehicle v2 = new Bike("B101", 500);

        Vehicle p1 = v1;
        Vehicle p2 = v2;

        p1.display(3);
        p2.display(2);
    }
}