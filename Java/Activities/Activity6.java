package activities;
import java.util.*;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int n)
    {
        maxPassengers = n;
        passengers = new ArrayList<>();
    }
    public void onboard(String s)
    {
        passengers.add(s);
    }
    public Date takeOff()
    {
        lastTimeTookOf = new Date();
        return (lastTimeTookOf);
    }
    public void land()
    {
        lastTimeLanded = new Date();
        passengers.clear();
    }
    public Date getLastTimeLanded()
    {
        return lastTimeLanded;
    }
     public List<String> getPassengers()
     {
         return passengers;
     }
}
public class Activity6 {
    public static void main(String[] args) throws InterruptedException
    {
        Plane todaysPlane = new Plane(10);
        todaysPlane.onboard("P1");
        todaysPlane.onboard("P2");
        todaysPlane.onboard("P3");
        todaysPlane.onboard("P4");
        todaysPlane.onboard("P5");
        todaysPlane.onboard("P6");
        System.out.println("Time of take off: " + todaysPlane.takeOff());
        todaysPlane.getPassengers();
        System.out.println("List of Passengers:" + todaysPlane.getPassengers());

        System.out.println();
        Thread.sleep(5000);
        todaysPlane.land();
        System.out.println("Time of Landing: " + todaysPlane.getLastTimeLanded());
        System.out.println("List of Passengers after landing:" + todaysPlane.getPassengers());
    }


}
