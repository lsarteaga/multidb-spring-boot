package com.example.multipledb.controller;

import com.example.multipledb.model.ConsultaModel;
import com.example.multipledb.service.implementation.ConsultaServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${api.endpoint.accounting}" + "/consulta")
@CrossOrigin("*")
public class ConsultaController {
    @Autowired
    private ConsultaServiceImplementation consultaService;

    @PostMapping ("/{centro}/create")
    public ResponseEntity<String> saveConsulta(@RequestBody ConsultaModel consultaModel,
                                               @PathVariable(name = "centro") int idCentro) {
        return new ResponseEntity<>(consultaService.saveConsulta(consultaModel, idCentro), HttpStatus.CREATED);
    }

    @PutMapping("/{centro}/{id}/update")
    public ResponseEntity<String> updateConsulta(@RequestBody ConsultaModel consultaModel,
                                                 @PathVariable(name = "centro") int idCentro,
                                                 @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(consultaService.updateConsulta(consultaModel, idCentro, id), HttpStatus.OK);
    }

    @DeleteMapping("/{centro}/{id}/delete")
    public ResponseEntity<String> deleteConsulta(@PathVariable(name = "centro") int idCentro,
                                                 @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(consultaService.deleteConsulta(idCentro, id), HttpStatus.OK);
    }

    @GetMapping("/{centro}/{empleado}/empleado")
    public List<ConsultaModel> getEmpleadoConsultas(@PathVariable(name = "centro") int idCentro,
                                                    @PathVariable(name = "empleado") int idEmpleado) {
        return consultaService.getEmpleadoConsultas(idCentro, idEmpleado);
    }

    @GetMapping("/{centro}/{id}/show")
    public ResponseEntity<ConsultaModel> getConsulta(@PathVariable(name = "centro") int idCentro,
                                     @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(consultaService.getConsulta(idCentro, id), HttpStatus.OK);
    }

    @GetMapping("/{centro}/show")
    public List<ConsultaModel> getConsultas(@PathVariable(name = "centro") int idCentro) {
        return consultaService.getConsultas(idCentro);
    }
}
