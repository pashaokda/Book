package com.example.demo;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class findBooks implements FindBookInterface {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Book> findAll() {

        String sql = "SELECT * FROM bilet";
        return jtm.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void deleteById(long id) {

        String sql = "DELETE FROM bilet WHERE id = ? ";
        int res = jtm.update(sql, id);
        if (res == 0)
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"
        );
    }

    @Override
    public Book findById(Long id) {
        String sql = "SELECT * FROM bilet WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void insertBook(String name, String author) {
        String sql = "INSERT INTO bilet(name, author) VALUES (?, ?)";
        Object[] params = new Object[] {name, author};
        jtm.update(sql, params);
    }
}