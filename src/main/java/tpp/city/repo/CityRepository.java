package tpp.city.repo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tpp.city.model.City;

@Repository
public class CityRepository {
    private final JdbcTemplate jdbcTemplate;

    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Отримання всіх міст
    public List<City> getAllCities() {
        return jdbcTemplate.query("SELECT * FROM City",
                (rs, rowNum) -> new City(rs.getInt("city_id"), rs.getString("city_name")));
    }

    public int addCity(String name) {
        return jdbcTemplate.update("INSERT INTO City (city_name) VALUES (?)", name);
    }

    public int updateCity(int id, String name) {
        return jdbcTemplate.update("UPDATE City SET city_name = ? WHERE city_id = ?", name, id);
    }

    public int deleteCity(int id) {
        return jdbcTemplate.update("DELETE FROM City WHERE city_id = ?", id);
    }
}
