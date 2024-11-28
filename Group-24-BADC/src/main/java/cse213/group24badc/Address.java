package cse213.group24badc;

public class Address {

    private String userName, street, city, state ;
    private int postalCode;
    static String  country = "Bangladesh";

    public Address(String userName, String street, String city, String state, int postalCode) {
        this.userName = userName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Address() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return street + ", " + city + ", " + state + ", "+ country + " - " + postalCode + ".";
    }
};

