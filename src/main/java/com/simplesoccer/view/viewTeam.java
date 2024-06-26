package com.simplesoccer.view;

import java.util.ArrayList;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Coach;
import com.simplesoccer.entity.Doctor;
import com.simplesoccer.entity.Player;
import com.simplesoccer.entity.Team;
import com.simplesoccer.util.ConsoleUtils;

public class viewTeam {
    public static Controller controlador;

    public void start() {
        
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("---------------------------------------\n" +
            "        Gestion de Equipos        \n" +
            "---------------------------------------\n" +
            "1. Crear Equipo\n" +
            "2. Actualizar Equipo\n" +
            "3. Buscar Equipo\n" +
            "4. Eliminar Equipo\n" +
            "5. Listar todos Equipos\n" +
            "6. Salir\n" +
            "\n" +
            "Ingrese una opción: ");


            int choice = ConsoleUtils.verificarEntradaInt(1, 6);
            
            Team equipo = new Team();

            ArrayList<Player> jugadores = new ArrayList<>();
            ArrayList<Coach> entrenadores = new ArrayList<>();
            ArrayList<Doctor> masajistas = new ArrayList<>();

            switch (choice) {
                case 1:
                    crearEquipo(equipo, jugadores, entrenadores, masajistas);
                    break;
                case 2:
                    actualizarEquipo();
                    break;
                case 3:
                    buscarEquipo();
                    break;
                case 4:
                    eliminarEquipo();
                    break;
                case 5:
                    listarEquipos();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    private void crearEquipo(Team equipo, ArrayList<Player> jugadores, ArrayList<Coach> entrenadores, ArrayList<Doctor> masajistas) {
        int codigoEquipo;

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del equipo :");
        codigoEquipo = ConsoleUtils.verificarIntSinRango();

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese Nombre del equipo :");
        equipo.setNombre(ConsoleUtils.verificarEntradaString());

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese la ciudad :");
        equipo.setCiudad(ConsoleUtils.verificarEntradaString());

        agregarJugadores(jugadores);
        equipo.setListJugadores(jugadores);

        agregarEntrenadores(entrenadores);
        equipo.setListEntrenadores(entrenadores);

        agregarMasajistas(masajistas);
        equipo.setListMasajistas(masajistas);

        controlador.equipos.put(codigoEquipo, equipo);
    }

    private void agregarJugadores(ArrayList<Player> jugadores) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del jugador: ");
            int idJugador = ConsoleUtils.verificarIntSinRango();
            Player jugador = new Player();
            jugador.setId(idJugador);
            jugadores.add(jugador);

            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro jugador? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarEntrenadores(ArrayList<Coach> entrenadores) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del entrenador");
            int idEntrenador = ConsoleUtils.verificarIntSinRango();
            Coach entrenador = new Coach();
            entrenador.setId(idEntrenador);
            entrenadores.add(entrenador);
            
            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro entrenador? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarMasajistas(ArrayList<Doctor> masajistas) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del masajista: ");
            int idMasajista = ConsoleUtils.verificarIntSinRango();
            Doctor masajista = new Doctor();
            masajista.setId(idMasajista);
            masajistas.add(masajista);

            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro masajista? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void actualizarEquipo() {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del equipo a actualizar: ");
        int codigoEquipo = ConsoleUtils.verificarIntSinRango();
        
        if (controlador.equipos.containsKey(codigoEquipo)) {
            Team equipoAct = controlador.equipos.get(codigoEquipo);
            ConsoleUtils.clearScreen();
            System.out.println("""
            Que deseas actualizar?
            1. Nombre del equipo
            2. Ciudad del equipo
            3. Salir
            """);
            int choice2 = ConsoleUtils.verificarEntradaInt(1, 3);
            
            switch (choice2) {
                case 1:
                    ConsoleUtils.clearScreen();
                    System.out.println("Ingresa el nuevo nombre del equipo");
                    equipoAct.setNombre(ConsoleUtils.verificarEntradaString());
                    break;
                case 2:
                    ConsoleUtils.clearScreen();
                    System.out.println("Ingresa la nueva ciudad del equipo");
                    equipoAct.setCiudad(ConsoleUtils.verificarEntradaString());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        } else {
            System.out.println("El equipo con el codigo " + codigoEquipo + " no existe.");
        }
    }

    private void buscarEquipo() {
        boolean encontrado = false;

        while (!encontrado) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el codigo del equipo a buscar: ");
            System.out.println("Si desea salir ingrese el numero 0");
            int codeEquipo = ConsoleUtils.verificarIntSinRango();

            if (codeEquipo == 0) {
                System.out.println("Saliendo...");
                
                ConsoleUtils.waitWindow();
                break;
            }

            if (controlador.equipos.containsKey(codeEquipo)) {
                Team eq = controlador.equipos.get(codeEquipo);
                ConsoleUtils.clearScreen();
                System.out.println("Nombre: " + eq.getNombre());
                System.out.println("Ciudad: " + eq.getCiudad());
                System.out.println("Jugadores: " + eq.getListJugadores());
                System.out.println("Entrenadores: " + eq.getListEntrenadores());
                System.out.println("Masajistas: " + eq.getListMasajistas());
                encontrado = true;

                ConsoleUtils.waitWindow();
                break;
            } else {
                System.out.println("El equipo con el ID " + codeEquipo + " no existe.");

                ConsoleUtils.waitWindow();
                break;
            }
        }
    }

    private void eliminarEquipo() {
        ConsoleUtils.clearScreen();
        Team eqa = new Team();
        System.out.println("Ingrese el id del equipo a eliminar: ");
        int idEquipoEliminar = ConsoleUtils.verificarIntSinRango();

        if(controlador.equipos.contains(idEquipoEliminar)) {
            controlador.equipos.remove(idEquipoEliminar);
            System.out.println("El equipo " + eqa.getNombre() + " ha sido eliminado");
        } else {
            System.out.println("El equipo con " + idEquipoEliminar + " no existe");
        }
        ConsoleUtils.waitWindow();

    }
    
    private void listarEquipos() {
        ConsoleUtils.clearScreen();
        System.out.println("Lista de todos los equipos:");
        for (int codigo : controlador.equipos.keySet()) {
            Team eq = controlador.equipos.get(codigo);
            System.out.println("");
            System.out.println("Codigo: " + codigo);
            System.out.println("Nombre: " + eq.getNombre());
            System.out.println("Ciudad: " + eq.getCiudad());
        }
        ConsoleUtils.waitWindow();
    }

}