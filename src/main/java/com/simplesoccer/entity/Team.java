package com.simplesoccer.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private String ciudad;
    private List<Player> listJugadores;
    private List<Coach> listEntrenadores;
    private List<Doctor> listMasajistas;
    
    public Team() {
        listEntrenadores = new ArrayList<Coach>();
        listJugadores = new ArrayList<Player>();
        listMasajistas = new ArrayList<Doctor>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Player> getListJugadores() {
        return listJugadores;
    }

    public void setListJugadores(List<Player> players) {
        this.listJugadores.addAll(players);
    }

    public List<Coach> getListEntrenadores() {
        return listEntrenadores;
    }

    public void setListEntrenadores(List<Coach> coachs) {
        this.listEntrenadores.addAll(coachs);
    }

    public List<Doctor> getListMasajistas() {
        return listMasajistas;
    }

    public void setListMasajistas(List<Doctor> masajistas) {
        this.listMasajistas.addAll(masajistas);
    }
}
