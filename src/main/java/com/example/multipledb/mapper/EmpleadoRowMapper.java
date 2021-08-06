package com.example.multipledb.mapper;

import com.example.multipledb.model.EmpleadoModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoRowMapper implements RowMapper<EmpleadoModel> {

    @Override
    public EmpleadoModel mapRow(ResultSet resultSet, int i) throws SQLException {
        EmpleadoModel empleado = new EmpleadoModel();
        empleado.setId(resultSet.getInt("id"));
        empleado.setNombre(resultSet.getString("nombre"));
        empleado.setDireccion(resultSet.getString("direccion"));
        empleado.setFechaEntrada(resultSet.getDate("fecha_entrada"));
        empleado.setIdCentro(resultSet.getInt("id_centro"));
        empleado.setSalario(resultSet.getDouble("salario"));
        return empleado;
    }
}
