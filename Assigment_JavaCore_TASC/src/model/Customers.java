package model;

public class Customers {

    private String maKH;
    private String name;
    private String email;
    private String phoneNumber;

    public Customers() {
    }

    public Customers(String maKH, String name, String email, String phoneNumber) {
        this.maKH = maKH;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "maKH='" + maKH + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
