package com.example.multipledb.service.implementation;

import com.example.multipledb.dao.MedicoDao;
import com.example.multipledb.model.MedicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImplementation {
    @Autowired
    private MedicoDao medicoDao;

    public List<MedicoModel> getMedicos(int idCentro) {
        return medicoDao.getMedicos(idCentro);
    }

    public MedicoModel getMedico(int idCentro, int id) {
        return medicoDao.getMedico(idCentro, id);
    }
}
