package tpp.city.model;

public class Apartment {
    private int apartmentId;
    private int houseId;  // Foreign key на таблицю House
    private int apartmentNumber;

    public Apartment() {}

    public Apartment(int apartmentId, int houseId, int apartmentNumber) {
        this.apartmentId = apartmentId;
        this.houseId = houseId;
        this.apartmentNumber = apartmentNumber;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
