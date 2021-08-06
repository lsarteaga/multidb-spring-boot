package com.example.multipledb.controller;

import com.example.multipledb.model.CentroModel;
import com.example.multipledb.service.implementation.CentroServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.accounting}" + "/centro")
@CrossOrigin("*")
public class CentroController {

    @Autowired
    private CentroServiceImplementation centroService;

    @GetMapping
    public List<CentroModel> getAllCenters() {
        return centroService.getAllCenters();
    }

    @GetMapping("/{id}/show")
    public List<CentroModel> getCenter(@PathVariable(name = "id") int id) {
        return centroService.getCenter(id);
    }
}
