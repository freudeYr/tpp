package tpp.city.repo;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tpp.city.model.Apartment;

@Repository
public class ApartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public ApartmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Apartment> getAllApartments() {
        String sql = "SELECT * FROM Apartment";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Apartment apartment = new Apartment();
            apartment.setApartmentId(rs.getInt("apartment_id"));
            apartment.setHouseId(rs.getInt("house_id"));
            apartment.setApartmentNumber(rs.getInt("apartment_number"));
            return apartment;
        });
    }

    public void addApartment(int apartmentNumber, int houseId) {
        String sql = "INSERT INTO Apartment (house_id, apartment_number) VALUES (?, ?)";
        jdbcTemplate.update(sql, houseId, apartmentNumber);
    }

    public void deleteApartment(int apartmentId) {
        String sql = "DELETE FROM Apartment WHERE apartment_id = ?";
        jdbcTemplate.update(sql, apartmentId);
    }

    public void updateApartment(int apartmentId, int apartmentNumber) {
        String sql = "UPDATE Apartment SET apartment_number = ? WHERE apartment_id = ?";
        jdbcTemplate.update(sql, apartmentNumber, apartmentId);
    }

    public Apartment getApartmentById(int apartmentId) {
        try {
            String sql = "SELECT * FROM Apartment WHERE apartment_id = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Apartment apartment = new Apartment();
                apartment.setApartmentId(rs.getInt("apartment_id"));
                apartment.setHouseId(rs.getInt("house_id"));
                apartment.setApartmentNumber(rs.getInt("apartment_number"));
                return apartment;
            }, apartmentId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
