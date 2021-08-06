package com.example.multipledb.dao;

import com.example.multipledb.mapper.CentroRowMapper;
import com.example.multipledb.model.CentroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CentroDao {

    @Autowired
    @Qualifier("jdbcTemplateQuito")
    private JdbcTemplate jdbcTemplateQuito;

    public List<CentroModel> getAllCenters() {
        String sql = "select * from centro";
        List<CentroModel> centros = jdbcTemplateQuito.query(sql, new CentroRowMapper());
        return centros;
    }

    public List<CentroModel> getCenter(int id) {
        String sql = "select * from centro where id = ?";
        List<CentroModel> centro = jdbcTemplateQuito.query(sql, new CentroRowMapper(), id);
        return centro;
    }
}
