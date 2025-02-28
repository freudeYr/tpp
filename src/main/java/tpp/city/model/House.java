package tpp.city.model;

public class House {
    private int houseId;
    private int streetId;  // Foreign key на таблицю Street
    private String houseNumber;

    public House() {}

    public House(int houseId, int streetId, String houseNumber) {
        this.houseId = houseId;
        this.streetId = streetId;
        this.houseNumber = houseNumber;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
