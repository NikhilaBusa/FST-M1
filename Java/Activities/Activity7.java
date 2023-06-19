package activities;

interface BicycleParts
{
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations
{
    public void applyBrake(int dec);
    public void speedUp(int inc);
}

class Bicycle implements BicycleOperations, BicycleParts
{
    public int gears;
    public int speed;
    public void Bicycle(int g, int s)
    {
        gears = g;
        speed = s;
    }

    @Override
    public void applyBrake(int dec) {
        speed-=dec;
    }

    @Override
    public void speedUp(int inc) {
        speed+=inc;
    }

    public String bicycleDesc()
    {
        return ("No. of gears: " + gears + "\nSpeed: " + speed);
    }
}
class MountainBike extends Bicycle
{
    public int seatHeight;
    public MountainBike(int g, int s, int sh)
    {
        super.gears = g;
        super.speed = s;
        seatHeight = sh;
    }
    public void setHeight(int sh)
    {
        seatHeight = sh;
    }
    public String bicycleDesc()
    {
        return ("No. of gears: " + gears + "\nSpeed: " + speed + "\nSeat height: " + seatHeight);
    }
}
public class Activity7 {
    public static void main(String[] args)
    {
        MountainBike nectar = new MountainBike(3,0,25);
        System.out.println(nectar.bicycleDesc());
        nectar.speedUp(20);
        nectar.applyBrake(5);
        System.out.println("After operations:\n" + nectar.bicycleDesc());
    }
}
