package com.example.multipledb.controller;

import com.example.multipledb.model.MedicoModel;
import com.example.multipledb.service.implementation.MedicoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.accounting}" + "/medico")
@CrossOrigin("*")
public class MedicoController {

    @Autowired
    private MedicoServiceImplementation medicoService;

    @GetMapping("/{centro}")
    public List<MedicoModel> getMedicos(@PathVariable(name = "centro") int idCentro) {
        return medicoService.getMedicos(idCentro);
    }

    @GetMapping("/{centro}/{id}/show")
    public MedicoModel getMedico(@PathVariable(name = "centro") int idCentro,
                                 @PathVariable(name = "id") int id) {
        return medicoService.getMedico(idCentro, id);
    }
}
