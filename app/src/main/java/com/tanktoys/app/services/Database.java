package com.tanktoys.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.User;

@Service
public class Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> run() throws Exception {
        String sql = "select * from addresses";
         
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString(1), rs.getString(2));
                return user;
            }
            
        });
    }
}
