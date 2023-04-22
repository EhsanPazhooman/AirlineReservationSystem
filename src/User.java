import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private int charge;

    static Ticket[] tickets;

    static Ticket ticket;

    ////////////Empty Constructor////////////
    public User(){

    }
    //////////Username & password Constructor/////////
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //////////Ticket Constructor////////////
    public User(Ticket[] tickets) {
        this.tickets = tickets;
    }

    ////////////Username getter & setter//////////////
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}
    ///////////Password getter & setter/////////////
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    ////////////Charge getter & setter////////////
    public int getCharge() {
        return charge;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }

    //////////////Ticket[] getter & setter//////////
    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    ///////////////Ticket getter & setter///////////
    public static Ticket getTicket() {
        return ticket;
    }

    public static void setTicket(Ticket ticket) {
        User.ticket = ticket;
    }
    ////////////////////////////////////////////////
    @Override
    public String toString() {
        return "User{" +
                "tickets=" + Arrays.toString(tickets) +
                '}';
    }
}
