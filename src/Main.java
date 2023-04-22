import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Passenger passenger = new Passenger();
        Login login = new Login();
        Tickets tickets = new Tickets();
        Flightschedules flightschedules = new Flightschedules();
        flightschedules.add_default_flights();
        Login.mainMenu();

    }
    ///////////////System Pause Method//////////////////////
    public static void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}


