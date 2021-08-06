package com.example.multipledb.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "consulta", schema = "centro_medico", catalog = "")
public class ConsultaModel {
    private int id;
    private Integer idCentro;
    private Integer idEmpleado;
    private Integer idEspecialidad;
    private Date fecha;
    private Time hora;
    private String paciente;
    private CentroModel centro;
    private EmpleadoModel empleado;
    private EspecialidadModel especialidad;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_centro", nullable = true)
    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    @Basic
    @Column(name = "id_empleado", nullable = true)
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "id_especialidad", nullable = true)
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Basic
    @Column(name = "fecha", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "hora", nullable = true)
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Basic
    @Column(name = "paciente", nullable = true, length = 200)
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaModel that = (ConsultaModel) o;
        return id == that.id && Objects.equals(idCentro, that.idCentro) && Objects.equals(idEmpleado, that.idEmpleado) && Objects.equals(idEspecialidad, that.idEspecialidad) && Objects.equals(fecha, that.fecha) && Objects.equals(hora, that.hora) && Objects.equals(paciente, that.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCentro, idEmpleado, idEspecialidad, fecha, hora, paciente);
    }

    @ManyToOne
    @JoinColumn(name = "id_centro", referencedColumnName = "id")
    public CentroModel getCentro() {
        return centro;
    }

    public void setCentro(CentroModel centro) {
        this.centro = centro;
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    @ManyToOne
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id")
    public EspecialidadModel getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    }
}
