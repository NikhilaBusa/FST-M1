package activities;

public class Activity1 {
    public static void main(String[] args)
    {
        Car someCar = new Car();
        someCar.make = 2014;
        someCar.color = "Black";
        someCar.transmission = "Manual";
        someCar.displayCharacteristics();
        someCar.accelerate();
        someCar.brake();
    }
}

class Car {
    String color, transmission;
    int make, tyres, doors;
    public Car()
    {
        tyres=4;
        doors=4;
    }
    public void displayCharacteristics()
    {
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }
    public void accelerate()
    {
        System.out.println("Car is moving forward");
    }
    public void brake()
    {
        System.out.println("Car has stopped");
    }
}


