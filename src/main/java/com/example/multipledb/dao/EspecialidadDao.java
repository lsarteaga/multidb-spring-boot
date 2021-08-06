package com.example.multipledb.dao;

import com.example.multipledb.mapper.EspecialidadRowMapper;
import com.example.multipledb.model.EspecialidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class EspecialidadDao {
    @Autowired
    @Qualifier("jdbcTemplateQuito")
    private JdbcTemplate jdbcTemplateQuito;

    final String sqlEspecialidades = "select * from especialidad";
    final String sqlEspecialidad = "select * from especialidad where id = ?";

    public List<EspecialidadModel> getEspecialidades() {
        List<EspecialidadModel> especialidades = jdbcTemplateQuito.
                query(sqlEspecialidades, new EspecialidadRowMapper());
        return especialidades;
    }

    public EspecialidadModel getEspecialidad(int id) {
        EspecialidadModel especialidad = jdbcTemplateQuito
                .queryForObject(sqlEspecialidad, new EspecialidadRowMapper(), id);
        return especialidad;
    }

}
