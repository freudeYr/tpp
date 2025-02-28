package tpp.city.model;

public class Street {
    private int streetId;
    private int cityId;  // Foreign key на таблицю City
    private String streetName;

    public Street() {}

    public Street(int streetId, int cityId, String streetName) {
        this.streetId = streetId;
        this.cityId = cityId;
        this.streetName = streetName;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
