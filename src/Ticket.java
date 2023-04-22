public class Ticket {
    private String flightId ;
    private String origin ;
    private String destination ;
    private String date ;
    private String time;
    private int price;
    private String passengerName;
    private int ticketId ;

    public Ticket(String passengerName,String flightId,String origin, String destination, String date, String time, int price) {
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }
    //////////Passenger name getter & setter////////////////
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    /////////// FlightId getter & setter ///////////////
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    ////////// Origin getter & setter /////////////
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    ///////// Destination getter & setter //////////
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    ///////// Date getter & setter //////////
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //////////Time getter & setter ////////
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    ///////////Price getter & setter///////
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //////////TicketId getter & setter//////
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    ////////////////////////////////
    @Override
    public String toString() {
        return  "»▶ passengerName='" + passengerName + '\'' +
                ", ticketId='" + getTicketId() + '\'' +
                ",  flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price ;
    }
}
