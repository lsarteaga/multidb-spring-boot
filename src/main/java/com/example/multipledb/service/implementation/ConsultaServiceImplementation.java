package com.example.multipledb.service.implementation;

import com.example.multipledb.dao.ConsultaDao;
import com.example.multipledb.model.ConsultaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImplementation {
    @Autowired
    private ConsultaDao consultaDao;

    public String saveConsulta(ConsultaModel consultaModel, int idCentro) {
        return consultaDao.saveConsulta(consultaModel, idCentro);
    }

    public String updateConsulta(ConsultaModel consultaModel, int idCentro, int id) {
        return consultaDao.updateConsulta(consultaModel, idCentro, id);
    }

    public String deleteConsulta(int idCentro, int id) {
        return consultaDao.deleteConsulta(idCentro, id);
    }

    public List<ConsultaModel> getEmpleadoConsultas(int idCentro, int idEmpleado) {
        return consultaDao.getEmpleadoConsultas(idCentro, idEmpleado);
    }

    public ConsultaModel getConsulta(int idCentro, int id) {
        return consultaDao.getConsulta(idCentro, id);
    }

    public List<ConsultaModel> getConsultas(int idCentro) {
        return consultaDao.getConsultas(idCentro);
    }
}
