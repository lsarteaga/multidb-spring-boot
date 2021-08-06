package com.example.multipledb.service.implementation;

import com.example.multipledb.dao.CentroDao;
import com.example.multipledb.model.CentroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroServiceImplementation {

    @Autowired
    private CentroDao centroDao;

    public List<CentroModel> getAllCenters() {
        return centroDao.getAllCenters();
    }

    public List<CentroModel> getCenter(int id) {
        return centroDao.getCenter(id);
    }
}
