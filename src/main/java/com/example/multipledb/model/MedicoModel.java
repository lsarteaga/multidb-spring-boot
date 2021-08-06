package com.example.multipledb.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medico", schema = "centro_medico", catalog = "")
public class MedicoModel {
    private int id;
    private int idEmpleado;
    private String funcion;
    private String experiencia;
    private EmpleadoModel empleado;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_empleado", nullable = false)
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "funcion", nullable = true, length = 200)
    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Basic
    @Column(name = "experiencia", nullable = true, length = 500)
    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoModel that = (MedicoModel) o;
        return id == that.id && idEmpleado == that.idEmpleado && Objects.equals(funcion, that.funcion) && Objects.equals(experiencia, that.experiencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmpleado, funcion, experiencia);
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", nullable = false)
    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }
}
