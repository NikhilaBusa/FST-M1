package activities;

public class Activity3 {
    public static void main(String[] args)
    {
        double seconds = 1000000000;

        double earthSeconds = 31557600;
        double mercuryYear = 0.2408467;
        double venusYear = 0.61519726;
        double marsYear = 1.8808158;
        double jupiterYear = 11.862615;
        double saturnYear = 29.447498;
        double uranusYear = 84.016846;
        double neptuneYear = 164.79132;

        System.out.println("Age on Mercury: " + seconds/(earthSeconds*mercuryYear));
        System.out.println("Age on Venus: " + seconds/(earthSeconds*venusYear));
        System.out.println("Age on Earth: " + seconds/earthSeconds);
        System.out.println("Age on Mars: " + seconds/(earthSeconds*marsYear));
        System.out.println("Age on Jupiter: " + seconds/(earthSeconds*jupiterYear));
        System.out.println("Age on Saturn: " + seconds/(earthSeconds*saturnYear));
        System.out.println("Age on Uranus: " + seconds/(earthSeconds*uranusYear));
        System.out.println("Age on Neptune: " + seconds/(earthSeconds*neptuneYear));
    }
}
