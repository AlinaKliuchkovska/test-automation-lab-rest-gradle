package models;

public class Birth {
    private String date;
    private String country;
    private String city;

    public Birth() {
    }

    public Birth(String date, String country, String city) {
        this.date = date;
        this.country = country;
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
