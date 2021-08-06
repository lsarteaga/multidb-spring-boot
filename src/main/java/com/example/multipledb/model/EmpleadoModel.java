package com.example.multipledb.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empleado", schema = "centro_medico", catalog = "")
public class EmpleadoModel {
    private int id;
    private String nombre;
    private String direccion;
    private Double salario;
    private Date fechaEntrada;
    private int idCentro;
    private CentroModel centro;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "direccion", nullable = true, length = 500)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "salario", nullable = true, precision = 3)
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Basic
    @Column(name = "fecha_entrada", nullable = true)
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Basic
    @Column(name = "id_centro", nullable = false)
    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoModel that = (EmpleadoModel) o;
        return id == that.id && idCentro == that.idCentro && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(salario, that.salario) && Objects.equals(fechaEntrada, that.fechaEntrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, salario, fechaEntrada, idCentro);
    }


    @ManyToOne
    @JoinColumn(name = "id_centro", referencedColumnName = "id", nullable = false)
    public CentroModel getCentro() {
        return centro;
    }

    public void setCentro(CentroModel centro) {
        this.centro = centro;
    }

}
