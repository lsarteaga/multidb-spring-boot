package com.example.multipledb.mapper;

import com.example.multipledb.model.CentroModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CentroRowMapper implements RowMapper<CentroModel> {

    @Override
    public CentroModel mapRow(ResultSet resultSet, int i) throws SQLException {
        CentroModel centro = new CentroModel();
        centro.setId(resultSet.getInt("id"));
        centro.setNombre(resultSet.getString("nombre"));
        centro.setDireccion(resultSet.getString("direccion"));
        centro.setTelefono(resultSet.getString("telefono"));
        return centro;
    }
}
