package com.simplesoccer;

import com.simplesoccer.util.ConsoleUtils;
import com.simplesoccer.view.viewCoach;
import com.simplesoccer.view.viewDoctor;
import com.simplesoccer.view.viewPlayer;
import com.simplesoccer.view.viewTeam;

public class Main {

    public static void main(String[] args) {
        
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();
        Controller ctrlDoctor = new Controller();
        Controller ctrlCoach = new Controller();

        viewTeam.controlador = ctrlTeams;
        viewPlayer.controlador = ctrlPlayers;
        viewDoctor.controlador = ctrlDoctor;
        viewCoach.controlador = ctrlCoach;

        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewDoctor vd = new viewDoctor();
        viewCoach vc = new viewCoach();

        int opcion = 0;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("---------------------------------------\n" +
            "          Panel Administrador         \n" +
            "         Selecciona una Opcion        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Administrar Equipos\n" +
            "2. Administrar Jugadores\n" +
            "3. Administrar Doctores\n" +
            "4. Administrar Entrenadores\n" +
            "5. Salir\n"
            );

            opcion = ConsoleUtils.verificarEntradaInt(1, 5);

            switch (opcion) {
                case 1:
                    vt.start();
                    break;
                case 2:
                    vp.start();
                    break;
                case 3:
                    vd.start();
                    break;
                case 4:
                    vc.start();
                    break;
                case 5:
                    return;
            }
        }
    }
}
