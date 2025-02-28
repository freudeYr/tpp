package tpp.city.repo;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tpp.city.model.Street;

@Repository
public class StreetRepository {

    private final JdbcTemplate jdbcTemplate;

    public StreetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Street> getAllStreets() {
        String sql = "SELECT * FROM Street";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Street street = new Street();
            street.setStreetId(rs.getInt("street_id"));
            street.setCityId(rs.getInt("city_id"));
            street.setStreetName(rs.getString("street_name"));
            return street;
        });
    }

    public void addStreet(String streetName, int cityId) {
        String sql = "INSERT INTO Street (city_id, street_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, cityId, streetName);
    }

    public void deleteStreet(int streetId) {
        String sql = "DELETE FROM Street WHERE street_id = ?";
        jdbcTemplate.update(sql, streetId);
    }

    public void updateStreet(int streetId, String streetName) {
        String sql = "UPDATE Street SET street_name = ? WHERE street_id = ?";
        jdbcTemplate.update(sql, streetName, streetId);
    }

    // Отримання вулиці за ID
    public Street getStreetById(int streetId) {
        try {
            String sql = "SELECT * FROM Street WHERE street_id = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Street street = new Street();
                street.setStreetId(rs.getInt("street_id"));
                street.setCityId(rs.getInt("city_id"));
                street.setStreetName(rs.getString("street_name"));
                return street;
            }, streetId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
