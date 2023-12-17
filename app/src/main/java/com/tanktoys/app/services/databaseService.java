package com.tanktoys.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public <T> List<IDatabaseItem> SelectByKey(IDatabaseItem item, T key) {
        String sql = item.ToSELECT(key);

        List<IDatabaseItem> result = jdbcTemplate.query(sql, new RowMapper<IDatabaseItem>() {
            @Override
            public IDatabaseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                try {
                    return item.load(rs, rowNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        return result;
    }

    public boolean Insert(IDatabaseItem item) {
        String sql = item.ToINSERT();
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
