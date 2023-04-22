import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private int charge;

    ////////////Empty Constructor////////////
    public User(){

    }
    //////////Username & password Constructor/////////
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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


}
