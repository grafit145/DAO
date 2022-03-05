package ru.netology.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomersRepository {

    final static String scriptName = "JOIN.sql";

    private NamedParameterJdbcTemplate template;

    @Autowired
    public CustomersRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public static String read(String scriptName) {
        try (InputStream is = new ClassPathResource(scriptName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        String product_name = read(scriptName);
        return template.queryForList(product_name, new MapSqlParameterSource("name", name), String.class);
    }
}
