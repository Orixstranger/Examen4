package com.example.lenovo_user.votacionapp.modelo;

import java.util.List;

public class Persona {
    private String cedula;
    private String nombre;
    private String recinto;
    private String junta;
    private String direccion;
    private String provincia;
    private String canton;
    private String parroquia;
    private String zona;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String recinto, String junta, String direccion, String provincia, String canton, String parroquia, String zona) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.recinto = recinto;
        this.junta = junta;
        this.direccion = direccion;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.zona = zona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getJunta() {
        return junta;
    }

    public void setJunta(String junta) {
        this.junta = junta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
