package com.example.multipledb.mapper;

import com.example.multipledb.model.MedicoModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoRowMapper implements RowMapper<MedicoModel> {

    @Override
    public MedicoModel mapRow(ResultSet resultSet, int i) throws SQLException {
        MedicoModel medico = new MedicoModel();
        medico.setId(resultSet.getInt("id"));
        medico.setExperiencia(resultSet.getString("experiencia"));
        medico.setFuncion(resultSet.getString("funcion"));
        medico.setIdEmpleado(resultSet.getInt("id_empleado"));
        return medico;
    }
}
