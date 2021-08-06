package com.example.multipledb.dao;

import com.example.multipledb.mapper.CentroRowMapper;
import com.example.multipledb.mapper.ConsultaRowMapper;
import com.example.multipledb.mapper.EmpleadoRowMapper;
import com.example.multipledb.mapper.EspecialidadRowMapper;
import com.example.multipledb.model.CentroModel;
import com.example.multipledb.model.ConsultaModel;
import com.example.multipledb.model.EmpleadoModel;
import com.example.multipledb.model.EspecialidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ConsultaDao {
    @Autowired
    @Qualifier("jdbcTemplateQuito")
    private JdbcTemplate jdbcTemplateQuito;

    @Autowired
    @Qualifier("jdbcTemplateCuenca")
    private JdbcTemplate jdbcTemplateCuenca;

    @Autowired
    @Qualifier("jdbcTemplateGuayaquil")
    private JdbcTemplate jdbcTemplateGuayaquil;

    private int row;
    final String sqlConsulta = "select * from consulta where id = ?";
    final String sqlConsultas = "select * from consulta as c " +
            "LEFT JOIN centro as ce ON ce.id = c.id_centro WHERE ce.id = ?";

    final String sqlCrearConsulta = "insert into consulta " +
            "(fecha, hora, paciente, id_centro, id_especialidad, id_empleado)" +
            " values (?, ?, ?, ?, ?, ?)";
    final String sqlEditarConsulta = "update consulta set fecha = ?," +
            " hora = ?," +
            " paciente = ?," +
            " id_centro = ?," +
            " id_especialidad = ?," +
            " id_empleado = ? where id = ?";
    final String sqlEliminarConsulta = "delete from consulta where id = ?";
    final String sqlEmpleadoConsultas = "select * from consulta as c " +
            "INNER JOIN empleado as e ON c.id_empleado = e.id " +
            "LEFT JOIN centro as ce ON ce.id = e.id_centro WHERE ce.id = ? AND e.id = ?";

    final String sqlEmpleado = "select * from empleado where id = ?";
    final String sqlCentro = "select * from centro where id = ?";
    final String sqlEspecialidad = "select * from especialidad where id = ?";

    public ConsultaModel getConsulta(int idCentro, int id) {
        ConsultaModel consulta = new ConsultaModel();
        switch (idCentro) {
            case 4:
                consulta = jdbcTemplateCuenca.queryForObject(sqlConsulta, new ConsultaRowMapper(), id);
                break;
            case 5:
                consulta = jdbcTemplateQuito.queryForObject(sqlConsulta, new ConsultaRowMapper(), id);
                break;
            case 6:
                consulta = jdbcTemplateGuayaquil.queryForObject(sqlConsulta, new ConsultaRowMapper(), id);
                break;
        }
        consulta.setEmpleado(getEmpleado(consulta.getIdEmpleado()));
        consulta.setCentro(getCentro(consulta.getIdCentro()));
        consulta.setEspecialidad(getEspecialidad(consulta.getIdEspecialidad()));
        return consulta;
    }

    // historico de consultas
    public List<ConsultaModel> getConsultas(int idCentro) {
        List<ConsultaModel> consultas = new ArrayList<>();
        switch (idCentro) {
            case 4:
                consultas = jdbcTemplateCuenca.query(sqlConsultas,
                        new ConsultaRowMapper(), idCentro);
                break;
            case 5:
                consultas = jdbcTemplateQuito.query(sqlConsultas,
                        new ConsultaRowMapper(), idCentro);
                break;
            case 6:
                consultas = jdbcTemplateGuayaquil.query(sqlConsultas,
                        new ConsultaRowMapper(), idCentro);
                break;
        }
        for (ConsultaModel consultaModel : consultas) {
            consultaModel.setEmpleado(getEmpleado(consultaModel.getIdEmpleado()));
            consultaModel.setCentro(getCentro(consultaModel.getIdCentro()));
            consultaModel.setEspecialidad(getEspecialidad(consultaModel.getIdEspecialidad()));
        }
        return consultas;
    }

    public String saveConsulta(ConsultaModel consultaModel, int idCentro) {
        switch (idCentro) {
            // cuenca 4 , quito 5, guayaquil 6
            case 4:
                row = jdbcTemplateCuenca.update(sqlCrearConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado());
                break;
            case 5:
                row = jdbcTemplateQuito.update(sqlCrearConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado());
                break;
            case 6:
                row = jdbcTemplateGuayaquil.update(sqlCrearConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado());
                break;
        }

        if (row == 1) {
            return "Consulta guardada exitosamente";
        } else {
            return "Un error ha ocurrido";
        }
    }

    public String updateConsulta(ConsultaModel consultaModel, int idCentro, int id) {
        switch (idCentro) {
            case 4:
                row = jdbcTemplateCuenca.update(sqlEditarConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado(), id);
                break;
            case 5:
                row = jdbcTemplateQuito.update(sqlEditarConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado(), id);
                break;
            case 6:
                row = jdbcTemplateGuayaquil.update(sqlEditarConsulta,
                        consultaModel.getFecha(),
                        consultaModel.getHora(),
                        consultaModel.getPaciente(),
                        consultaModel.getIdCentro(),
                        consultaModel.getIdEspecialidad(),
                        consultaModel.getIdEmpleado(), id);
                break;
        }
        if (row == 1) {
            return "Consulta actualizada correctamente";
        } else {
            return "Un error ha ocurrido";
        }
    }

    public String deleteConsulta(int idCentro, int id) {
        switch (idCentro) {
            case 4:
                row = jdbcTemplateCuenca.update(sqlEliminarConsulta, id);
                break;
            case 5:
                row = jdbcTemplateQuito.update(sqlEliminarConsulta, id);
                break;
            case 6:
                row = jdbcTemplateGuayaquil.update(sqlEliminarConsulta, id);
                break;
        }
        if (row == 1) {
            return "Consulta eliminada correctamente";
        } else {
            return "Un error ha ocurrido";
        }
    }

    public List<ConsultaModel> getEmpleadoConsultas(int idCentro, int idEmpleado) {
        List<ConsultaModel> consultas = new ArrayList<>();
        switch (idCentro) {
            case 4:
                consultas = jdbcTemplateCuenca.query(sqlEmpleadoConsultas,
                        new ConsultaRowMapper(), idCentro, idEmpleado);
                break;
            case 5:
                consultas = jdbcTemplateQuito.query(sqlEmpleadoConsultas,
                        new ConsultaRowMapper(), idCentro, idEmpleado);
                break;
            case 6:
                consultas = jdbcTemplateGuayaquil.query(sqlEmpleadoConsultas,
                        new ConsultaRowMapper(), idCentro, idEmpleado);
                break;
        }
        for (ConsultaModel consultaModel : consultas) {
            consultaModel.setEmpleado(getEmpleado(consultaModel.getIdEmpleado()));
            consultaModel.setCentro(getCentro(consultaModel.getIdCentro()));
            consultaModel.setEspecialidad(getEspecialidad(consultaModel.getIdEspecialidad()));
        }
        return consultas;
    }

    public EmpleadoModel getEmpleado(int id) {
        EmpleadoModel empleado = jdbcTemplateQuito.queryForObject(sqlEmpleado, new EmpleadoRowMapper(), id);
        empleado.setCentro(getCentro(empleado.getIdCentro()));
        return empleado;
    }

    public CentroModel getCentro(int id) {
        CentroModel centro = jdbcTemplateQuito.queryForObject(sqlCentro, new CentroRowMapper(), id);
        return centro;
    }

    public EspecialidadModel getEspecialidad(int id) {
        EspecialidadModel especialidad = jdbcTemplateQuito.queryForObject(sqlEspecialidad, new EspecialidadRowMapper(), id);
        return especialidad;
    }
}
