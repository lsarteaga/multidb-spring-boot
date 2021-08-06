package com.example.multipledb.dao;

import com.example.multipledb.mapper.CentroRowMapper;
import com.example.multipledb.mapper.EmpleadoRowMapper;
import com.example.multipledb.mapper.MedicoRowMapper;
import com.example.multipledb.model.EmpleadoModel;
import com.example.multipledb.model.MedicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class MedicoDao {

    @Autowired
    @Qualifier("jdbcTemplateQuito")
    private JdbcTemplate jdbcTemplateQuito;

    final String sqlCentro = "select * from centro where id = ?";
    final String sqlMedicos = "select * from empleado as e " +
            "INNER JOIN medico as m ON e.id = m.id_empleado " +
            "LEFT JOIN centro as c ON c.id = e.id_centro WHERE c.id = ?";
    final String sqlMedico = "select * from empleado as e " +
            "INNER JOIN medico as m ON e.id = m.id_empleado " +
            "LEFT JOIN centro as c ON c.id = e.id_centro WHERE c.id = ? AND m.id = ?";

    public EmpleadoModel getEmpleado(int id) {
        String sql = "select * from empleado where id = ?";
        EmpleadoModel empleado = jdbcTemplateQuito.queryForObject(sql, new EmpleadoRowMapper(), id);
        empleado.setCentro(jdbcTemplateQuito.queryForObject(sqlCentro,
                new CentroRowMapper(), empleado.getIdCentro()));
        return empleado;
    }

    public MedicoModel getMedico(int idCentro, int id) {
        MedicoModel medico = jdbcTemplateQuito.queryForObject(sqlMedico, new MedicoRowMapper(), idCentro, id);
        medico.setEmpleado(getEmpleado(medico.getIdEmpleado()));
        return medico;
    }

    public List<MedicoModel> getMedicos(int idCentro) {
        List<MedicoModel> medicos = jdbcTemplateQuito.query(sqlMedicos, new MedicoRowMapper(), idCentro);
        for (MedicoModel medico : medicos) {
            medico.setEmpleado(getEmpleado(medico.getIdEmpleado()));
        }
        return medicos;
    }

}
