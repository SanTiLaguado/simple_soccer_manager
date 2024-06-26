package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Player;
import com.simplesoccer.util.ConsoleUtils;

public class viewPlayer {
    public static Controller controlador;

    public void start() {
        int op;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("---------------------------------------\n" +
            "        Gestion de Jugadores        \n" +
            "---------------------------------------\n" +
            "1. Crear Jugador\n" +
            "2. Actualizar Jugador\n" +
            "3. Eliminar Jugador\n" +
            "4. Listar todos los Jugadores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");


            op = ConsoleUtils.verificarEntradaInt(1, 5);
            
            switch (op) {
                case 1:
                    crearJugador();
                    break;

                case 2:
                    actualizarJugador();
                    break;

                case 3:
                    eliminarJugador();
                    break;

                case 4:
                    listarJugadores();
                    break;

                case 5:
                    return;

                default:
                    break;
            }
        }
    }

    private void crearJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del Jugador: ");
        int id = ConsoleUtils.verificarIntSinRango();
        
        System.out.print("Ingrese el Nombre del Jugador: ");
        String nombre = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese Apellidos del Jugador: ");
        String apellido = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese la Edad del Jugador: ");
        int edad = ConsoleUtils.verificarIntSinRango();

        System.out.print("Ingrese la dorsal: ");
        int dorsal = ConsoleUtils.verificarIntSinRango();

        System.out.print("Ingrese la posición: ");
        String posicion = ConsoleUtils.verificarEntradaString();

        Player nuevoJugador = new Player(id, nombre, apellido, edad, dorsal, posicion);
        controlador.jugadores.put(id, nuevoJugador);

        ConsoleUtils.clearScreen();
        System.out.println("");
        System.out.println("Jugador creado exitosamente.");
        ConsoleUtils.waitWindow();
    }

    private void actualizarJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del jugador a actualizar: ");
        int codigoJugador = ConsoleUtils.verificarIntSinRango();
    
        if (controlador.jugadores.containsKey(codigoJugador)) {
            Player jugadorAct = controlador.jugadores.get(codigoJugador);
            
            while (true) {
                ConsoleUtils.clearScreen();
                System.out.println("Jugador: " + jugadorAct.getNombre() + " " + jugadorAct.getApellido());
                System.out.println();
                System.out.println("""
                ¿Qué deseas actualizar?
                1. Nombre del Jugador
                2. Apellido del Jugador
                3. Edad del Jugador
                4. Dorsal del Jugador
                5. Posición del Jugador
                6. Salir
                """);
    
                int choice2 = ConsoleUtils.verificarEntradaInt(1, 6);
                
                switch (choice2) {
                    case 1:
                        actualizarNombre(jugadorAct);
                        break;
    
                    case 2:
                        actualizarApellido(jugadorAct);
                        break;
    
                    case 3:
                        actualizarEdad(jugadorAct);
                        break;
    
                    case 4:
                        actualizarDorsal(jugadorAct);
                        break;
    
                    case 5:
                        actualizarPosicion(jugadorAct);
                        break;
    
                    case 6:
                        return;  
    
                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                        break;
                }
            } 
        } else {
            System.out.println("El jugador con código " + codigoJugador + " no existe!");
        }
    }
    
    private void actualizarNombre(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo nombre del Jugador: ");
        String nuevoNombre = ConsoleUtils.verificarEntradaString();
        jugador.setNombre(nuevoNombre);
    }

    private void actualizarApellido(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo apellido del Jugador: ");
        String nuevoApellido = ConsoleUtils.verificarEntradaString();
        jugador.setApellido(nuevoApellido);
    }

    private void actualizarEdad(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva edad del Jugador: ");
        int nuevaEdad = ConsoleUtils.verificarIntSinRango();
        jugador.setEdad(nuevaEdad);
    }

    private void actualizarDorsal(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva dorsal del Jugador: ");
        int nuevaDorsal = ConsoleUtils.verificarIntSinRango();
        jugador.setDorsal(nuevaDorsal);
    }

    private void actualizarPosicion(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva posición del Jugador: ");
        String nuevaPosicion = ConsoleUtils.verificarEntradaString();
        jugador.setPosicion(nuevaPosicion);
    }

    private void eliminarJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del jugador a Eliminar: ");
        int codigoJugadorElim = ConsoleUtils.verificarIntSinRango();

        if (controlador.jugadores.containsKey(codigoJugadorElim)) {
            Player jugadorElim = controlador.jugadores.get(codigoJugadorElim);
            ConsoleUtils.clearScreen();
            System.out.println("Jugador: " + jugadorElim.getNombre() + " " + jugadorElim.getApellido());
            System.out.println("Edad: " + jugadorElim.getEdad() );
            System.out.println("Posición: " + jugadorElim.getPosicion());
            System.out.println("Dorsal: " + jugadorElim.getDorsal());
            System.out.print("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = ConsoleUtils.verificarEntradaInt(1, 2);

            if (conf == 1) {
                controlador.jugadores.remove(codigoJugadorElim);
                System.out.println("Jugador eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El jugador con código " + codigoJugadorElim + " no existe!");
        }
    }

    private void listarJugadores() {
        ConsoleUtils.clearScreen();
        System.out.println("Listado de jugadores: ");
        for (Integer key : controlador.jugadores.keySet()) {
            Player currentPlayer = controlador.jugadores.get(key);
            System.out.println("");
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentPlayer.getNombre());
            System.out.println("Apellido: " + currentPlayer.getApellido());
            System.out.println("Edad: " + currentPlayer.getEdad());
            System.out.println("Dorsal: " + currentPlayer.getDorsal());
            System.out.println("Posición: " + currentPlayer.getPosicion());
        }
        ConsoleUtils.waitWindow();
    }
}
