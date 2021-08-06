package com.example.multipledb.mapper;

import com.example.multipledb.model.EspecialidadModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadRowMapper implements RowMapper<EspecialidadModel> {

    @Override
    public EspecialidadModel mapRow(ResultSet resultSet, int i) throws SQLException {
        EspecialidadModel especialidad = new EspecialidadModel();
        especialidad.setId(resultSet.getInt("id"));
        especialidad.setNombre(resultSet.getString("nombre"));
        especialidad.setDescripcion(resultSet.getString("descripcion"));
        return especialidad;
    }
}
