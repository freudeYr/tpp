package tpp.city.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tpp.city.repo.QueryRepository;

@Controller
public class QueryController {

    private final QueryRepository sqlExecutorRepository;

    public QueryController(QueryRepository sqlExecutorRepository) {
        this.sqlExecutorRepository = sqlExecutorRepository;
    }

    // Головна сторінка з формою
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // Обробка sql запиту і виведення результату
    @PostMapping("/")
    public String executeSqlQuery(@RequestParam String sqlQuery, Model model) {
        try {
            String result = sqlExecutorRepository.executeSqlQuery(sqlQuery);  // Виконання запиту через репозиторій
            model.addAttribute("result", result);  // Додавання результату до моделі для відображення на сторінці
        } catch (Exception e) {
            model.addAttribute("result", "Помилка при виконанні запиту: " + e.getMessage());
        }
        return "index"; // Повернення на цю ж сторінку з результатом
    }
}
