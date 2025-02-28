package tpp.city.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QueryRepository {

    private final JdbcTemplate jdbcTemplate;

    public QueryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Метод для виконання SQL запиту
    public String executeSqlQuery(String sqlQuery) {
        try {
            if (sqlQuery.trim().toUpperCase().startsWith("SELECT")) {
                return jdbcTemplate.queryForList(sqlQuery).toString();
            } else {
                int rowsAffected = jdbcTemplate.update(sqlQuery);
                return "Запит виконано. Оброблено рядків: " + rowsAffected;
            }
        } catch (Exception e) {
            return "Помилка при виконанні запиту: " + e.getMessage();
        }
    }

    /*Методи для унеможливлення sql ін'єкцій та  */
    /*public String executeSqlQuery(String sqlQuery) {
        // Перевірка команд
        try {
            if (sqlQuery.toLowerCase().startsWith("insert")) {
                return handleInsertCommand(sqlQuery);
            }
            else if (sqlQuery.toLowerCase().startsWith("update")) {
                return handleUpdateCommand(sqlQuery);
            }
            else if (sqlQuery.toLowerCase().startsWith("delete")) {
                return handleDeleteCommand(sqlQuery);
            }
            else {
                return "Невідома команда SQL";
            }
        } catch (Exception e) {
            return "Помилка при виконанні запиту: " + e.getMessage(); // Прибрати
        }
    }
    
    private String handleInsertCommand(String sqlQuery) {
        // Формат: insert tableName(параметри)
        String[] parts = sqlQuery.split("\\(", 2);
        String tableName = parts[0].trim().split(" ")[1];
        String values = parts[1].replace(")", "").trim();
    
        // Генерація запиту для вставки в таблицю
        String insertQuery = "INSERT INTO " + tableName + " VALUES (" + values + ")";
        jdbcTemplate.update(insertQuery);
    
        return "Запит виконано: " + insertQuery;
    }
    
    private String handleUpdateCommand(String sqlQuery) {
        // Формат: update tableName(id об'єкта для оновлення, нове значення)
        String[] parts = sqlQuery.split("\\(", 2);
        String tableName = parts[0].trim().split(" ")[1];
        String values = parts[1].replace(")", "").trim();
        
        // Розділення id та значень
        String[] valuesArray = values.split(",", 2);
        String id = valuesArray[0].trim();
        String newValue = valuesArray[1].trim();
    
        // Генерація запиту для оновлення
        String updateQuery = "UPDATE " + tableName + " SET " + tableName.toLowerCase() + "_name = '" + newValue + "' WHERE " + tableName.toLowerCase() + "_id = " + id;
        jdbcTemplate.update(updateQuery);
    
        return "Запит виконано: " + updateQuery;
    }
    
    private String handleDeleteCommand(String sqlQuery) {
        // Формат: delete tableName(id об'єкта для видалення)
        String[] parts = sqlQuery.split("\\(", 2);
        String tableName = parts[0].trim().split(" ")[1];
        String id = parts[1].replace(")", "").trim();
    
        // Генерація запиту для видалення
        String deleteQuery = "DELETE FROM " + tableName + " WHERE " + tableName.toLowerCase() + "_id = " + id;
        jdbcTemplate.update(deleteQuery);
    
        return "Запит виконано: " + deleteQuery;
    }*/
}
