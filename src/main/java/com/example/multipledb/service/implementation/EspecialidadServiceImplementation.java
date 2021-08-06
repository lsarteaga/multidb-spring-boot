package com.example.multipledb.service.implementation;

import com.example.multipledb.dao.EspecialidadDao;
import com.example.multipledb.model.EspecialidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImplementation {

    @Autowired
    private EspecialidadDao especialidadDao;

    public List<EspecialidadModel> getEspecialidades() {
        return especialidadDao.getEspecialidades();
    }

    public EspecialidadModel getEspecialidad(int id) {
        return especialidadDao.getEspecialidad(id);
    }
}
