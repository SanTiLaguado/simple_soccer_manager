package com.simplesoccer;

import java.util.Hashtable;

import com.simplesoccer.entity.Coach;
import com.simplesoccer.entity.Doctor;
import com.simplesoccer.entity.Player;
import com.simplesoccer.entity.Team;

public class Controller {
    public Hashtable <Integer, Team> equipos = new Hashtable<>();
    public Hashtable <Integer, Player> jugadores = new Hashtable<>();
    public Hashtable <Integer, Coach> entrenadores = new Hashtable<>();
    public Hashtable <Integer, Doctor> doctores = new Hashtable<>();
}
