package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Coach;
import com.simplesoccer.util.ConsoleUtils;

public class viewCoach {
    public static Controller controlador;

    public void start() {
        int op;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("---------------------------------------\n" +
            "        Gestion de Entrenadores       \n" +
            "---------------------------------------\n" +
            "1. Crear Entrenador\n" +
            "2. Actualizar Entrenador\n" +
            "3. Eliminar Entrenador\n" +
            "4. Listar todos los Entrenadores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");

            op = ConsoleUtils.verificarEntradaInt(1, 5);
            
            switch (op) {
                case 1:
                    crearEntrenador();
                    break;

                case 2:
                    actualizarEntrenador();
                    break;

                case 3:
                    eliminarEntrenador();
                    break;

                case 4:
                    listarEntrenadores();
                    break;

                case 5:
                    return;

                default:
                    break;
            }
        }
    }

    private void crearEntrenador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del Entrenador: ");
        int id = ConsoleUtils.verificarIntSinRango();
        
        System.out.print("Ingrese el Nombre del Entrenador: ");
        String nombre = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese Apellidos del Entrenador: ");
        String apellido = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese la Edad del Entrenador: ");
        int edad = ConsoleUtils.verificarIntSinRango();

        System.out.print("Ingrese la ID de la federacion: ");
        int federacion = ConsoleUtils.verificarIntSinRango();

        Coach nuevoEntrenador = new Coach(id, nombre, apellido, edad, federacion);
        controlador.entrenadores.put(id, nuevoEntrenador);

        ConsoleUtils.clearScreen();
        System.out.println("");
        System.out.println("Entrenador creado exitosamente.");
        ConsoleUtils.waitWindow();
    }

    private void actualizarEntrenador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del Entrenador a actualizar: ");
        int codigoEntrenador = ConsoleUtils.verificarIntSinRango();
    
        if (controlador.entrenadores.containsKey(codigoEntrenador)) {
            Coach entrenadorAct = controlador.entrenadores.get(codigoEntrenador);
            
            while (true) {
                ConsoleUtils.clearScreen();
                System.out.println("Entrenador: " + entrenadorAct.getNombre() + " " + entrenadorAct.getApellido());
                System.out.println();
                System.out.println("""
                ¿Qué deseas actualizar?
                1. Nombre del Entrenador
                2. Apellido del Entrenador
                3. Edad del Entrenador
                4. ID de la Federacion
                5. Salir
                """);
    
                int choice2 = ConsoleUtils.verificarEntradaInt(1, 5);
                
                switch (choice2) {
                    case 1:
                        actualizarNombre(entrenadorAct);
                        break;
    
                    case 2:
                        actualizarApellido(entrenadorAct);
                        break;
    
                    case 3:
                        actualizarEdad(entrenadorAct);
                        break;
    
                    case 4:
                        actualizarIdFederacion(entrenadorAct);
                        break;

                    case 5:
                        return;  
    
                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                        break;
                }
            } 
        } else {
            System.out.println("El Entrenador con código " + codigoEntrenador + " no existe!");
        }
    }

    private void actualizarNombre(Coach entrenador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo nombre del Entrenador: ");
        String nuevoNombre = ConsoleUtils.verificarEntradaString();
        entrenador.setNombre(nuevoNombre);
    }

    private void actualizarApellido(Coach entrenador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo apellido del Entrenador: ");
        String nuevoApellido = ConsoleUtils.verificarEntradaString();
        entrenador.setApellido(nuevoApellido);
    }

    private void actualizarEdad(Coach entrenador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva edad del Entrenador: ");
        int nuevaEdad = ConsoleUtils.verificarIntSinRango();
        entrenador.setEdad(nuevaEdad);
    }

    private void actualizarIdFederacion(Coach entrenador) {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el nuevo titulo del Entrenador");
        int nuevoIdFederacion = ConsoleUtils.verificarIntSinRango();
        entrenador.setIdFederacion(nuevoIdFederacion);
    }

    private void eliminarEntrenador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del Entrenador a Eliminar: ");
        int codigoEntrenadorElim = ConsoleUtils.verificarIntSinRango();

        if (controlador.entrenadores.containsKey(codigoEntrenadorElim)) {
            Coach entrenadorElim = controlador.entrenadores.get(codigoEntrenadorElim);
            ConsoleUtils.clearScreen();
            System.out.println("Entrenador: " + entrenadorElim.getNombre() + " " + entrenadorElim.getApellido());
            System.out.println("Edad: " + entrenadorElim.getEdad() );
            System.out.println("ID federacion: " + entrenadorElim.getIdFederacion());
            System.out.println("");
            System.out.println("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = ConsoleUtils.verificarEntradaInt(1, 2);

            if (conf == 1) {
                controlador.entrenadores.remove(codigoEntrenadorElim);
                System.out.println("Entrenador eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El jugador con código " + codigoEntrenadorElim + " no existe!");
        }
    }

    private void listarEntrenadores() {
        ConsoleUtils.clearScreen();
        System.out.println("Listado de Entrenadores: ");
        for (Integer key : controlador.entrenadores.keySet()) {
            Coach currentEntrenadores = controlador.entrenadores.get(key);
            System.out.println("");
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentEntrenadores.getNombre());
            System.out.println("Apellido: " + currentEntrenadores.getApellido());
            System.out.println("Edad: " + currentEntrenadores.getEdad());
            System.out.println("ID Federacion: " + currentEntrenadores.getIdFederacion());
        }
        ConsoleUtils.waitWindow();
    }
}
