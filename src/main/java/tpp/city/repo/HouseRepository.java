package tpp.city.repo;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tpp.city.model.House;

@Repository
public class HouseRepository {

    private final JdbcTemplate jdbcTemplate;

    public HouseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<House> getAllHouses() {
        String sql = "SELECT * FROM House";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            House house = new House();
            house.setHouseId(rs.getInt("house_id"));
            house.setStreetId(rs.getInt("street_id"));
            house.setHouseNumber(rs.getString("house_number"));
            return house;
        });
    }

    public void addHouse(String houseNumber, int streetId) {
        String sql = "INSERT INTO House (street_id, house_number) VALUES (?, ?)";
        jdbcTemplate.update(sql, streetId, houseNumber);
    }

    public void deleteHouse(int houseId) {
        String sql = "DELETE FROM House WHERE house_id = ?";
        jdbcTemplate.update(sql, houseId);
    }

    public void updateHouse(int houseId, String houseNumber) {
        String sql = "UPDATE House SET house_number = ? WHERE house_id = ?";
        jdbcTemplate.update(sql, houseNumber, houseId);
    }

    public House getHouseById(int houseId) {
        try {
            String sql = "SELECT * FROM House WHERE house_id = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                House house = new House();
                house.setHouseId(rs.getInt("house_id"));
                house.setStreetId(rs.getInt("street_id"));
                house.setHouseNumber(rs.getString("house_number"));
                return house;
            }, houseId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
