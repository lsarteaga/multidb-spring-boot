package com.example.multipledb.mapper;

import com.example.multipledb.model.ConsultaModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaRowMapper implements RowMapper<ConsultaModel> {

    @Override
    public ConsultaModel mapRow(ResultSet resultSet, int i) throws SQLException {
        ConsultaModel consulta = new ConsultaModel();
        consulta.setId(resultSet.getInt("id"));
        consulta.setFecha(resultSet.getDate("fecha"));
        consulta.setHora(resultSet.getTime("hora"));
        consulta.setPaciente(resultSet.getString("paciente"));
        consulta.setIdCentro(resultSet.getInt("id_centro"));
        consulta.setIdEmpleado(resultSet.getInt("id_empleado"));
        consulta.setIdEspecialidad(resultSet.getInt("id_especialidad"));
        return consulta;
    }
}
