package com.example.multipledb.controller;

import com.example.multipledb.model.EspecialidadModel;
import com.example.multipledb.service.implementation.EspecialidadServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.accounting}" + "/especialidad")
@CrossOrigin("*")
public class EspecialidadController {

    @Autowired
    private EspecialidadServiceImplementation especialidadService;

    @GetMapping
    public List<EspecialidadModel> getEspecialidades() {
        return especialidadService.getEspecialidades();
    }

    @GetMapping("/{id}/show")
    public EspecialidadModel getEspecialidad(@PathVariable(name = "id") int id) {
        return especialidadService.getEspecialidad(id);
    }
}
