package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Doctor;
import com.simplesoccer.util.ConsoleUtils;

public class viewDoctor {
    public static Controller controlador;

    public void start(){
        int op;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("---------------------------------------\n" +
            "        Gestion de Doctores        \n" +
            "---------------------------------------\n" +
            "1. Crear Doctor\n" +
            "2. Actualizar Doctor\n" +
            "3. Eliminar Doctor\n" +
            "4. Listar todos los Doctores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");


            op = ConsoleUtils.verificarEntradaInt(1, 5);
            
            switch (op) {
                case 1:
                    crearDoctor();
                    break;

                case 2:
                    actualizarDoctor();
                    break;

                case 3:
                    eliminarDoctor();
                    break;

                case 4:
                    listarDoctores();
                    break;

                case 5:
                    return;

                default:
                    break;
            }
        }
    }

    private void crearDoctor(){
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del Doctor: ");
        int id = ConsoleUtils.verificarIntSinRango();

        System.out.print("Ingrese el Nombre del Doctor: ");
        String nombre = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese Apellidos del Doctor: ");
        String apellido = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese la Edad del Doctor: ");
        int edad = ConsoleUtils.verificarIntSinRango();

        System.out.print("Ingrese el titulo: ");
        String titulo = ConsoleUtils.verificarEntradaString();

        System.out.print("Ingrese los años de experiencia: ");
        int años_exp = ConsoleUtils.verificarIntSinRango();

        Doctor nuevoDoctor = new Doctor(id, nombre, apellido, edad, titulo, años_exp);
        controlador.doctores.put(id, nuevoDoctor);

        ConsoleUtils.clearScreen();
        System.out.println("");
        System.out.println("Doctor creado exitosamente.");
        ConsoleUtils.waitWindow();
    }

    private void actualizarDoctor() {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del doctor a actualizar: ");
        int codigoDoctor = ConsoleUtils.verificarIntSinRango();

         if (controlador.doctores.containsKey(codigoDoctor)) {
            Doctor doctorAct = controlador.doctores.get(codigoDoctor);
            
            while (true) {
                ConsoleUtils.clearScreen();
                System.out.println("Doctor: " + doctorAct.getNombre() + " " + doctorAct.getApellido());
                System.out.println();
                System.out.println("""
                ¿Qué deseas actualizar?
                1. Nombre del Doctor
                2. Apellido del Doctor
                3. Edad del Doctor
                4. titulo del Doctor
                5. Años de experiencia del Doctor
                6. Salir
                """);
    
                int choice2 = ConsoleUtils.verificarEntradaInt(1, 6);
                
                switch (choice2) {
                    case 1:
                        actualizarNombre(doctorAct);
                        break;
    
                    case 2:
                        actualizarApellido(doctorAct);
                        break;
    
                    case 3:
                        actualizarEdad(doctorAct);
                        break;
    
                    case 4:
                        actualizarTitulo(doctorAct);
                        break;
    
                    case 5:
                        actualizarAñosExp(doctorAct);
                        break;
    
                    case 6:
                        return;  
    
                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                        break;
                }
            } 
        } else {
            System.out.println("El doctor con código " + codigoDoctor + " no existe!");
        }
    }

    private void actualizarNombre(Doctor doctor) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo nombre del doctor: ");
        String nuevoNombre = ConsoleUtils.verificarEntradaString();
        doctor.setNombre(nuevoNombre);
    }

    private void actualizarApellido(Doctor doctor) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo apellido del doctor: ");
        String nuevoApellido = ConsoleUtils.verificarEntradaString();
        doctor.setApellido(nuevoApellido);
    }

    private void actualizarEdad(Doctor doctor) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva edad del doctor: ");
        int nuevaEdad = ConsoleUtils.verificarIntSinRango();
        doctor.setEdad(nuevaEdad);
    }

    private void actualizarTitulo(Doctor doctor) {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el nuevo titulo del doctor");
        String nuevoTitulo = ConsoleUtils.verificarEntradaString();
        doctor.setTitulo(nuevoTitulo);
    }

    private void actualizarAñosExp(Doctor doctor) {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese nuevo registro de años de experiencia del doctor");
        int nuevoAñoExp = ConsoleUtils.verificarIntSinRango();
        doctor.setExpYear(nuevoAñoExp);
    }

    private void eliminarDoctor() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del doctor a Eliminar: ");
        int codigoDoctorElim = ConsoleUtils.verificarIntSinRango();

        if (controlador.doctores.containsKey(codigoDoctorElim)) {
            Doctor doctorElim = controlador.doctores.get(codigoDoctorElim);
            ConsoleUtils.clearScreen();
            System.out.println("Jugador: " + doctorElim.getNombre() + " " + doctorElim.getApellido());
            System.out.println("Edad: " + doctorElim.getEdad() );
            System.out.println("Titulo: " + doctorElim.getTitulo());
            System.out.println("Años experiencia: " + doctorElim.getExpYear());
            System.out.println("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = ConsoleUtils.verificarEntradaInt(1, 2);

            if (conf == 1) {
                controlador.doctores.remove(codigoDoctorElim);
                System.out.println("Doctor eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El jugador con código " + codigoDoctorElim + " no existe!");
        }
    }

    private void listarDoctores() {
        ConsoleUtils.clearScreen();
        System.out.println("Listado de Doctores: ");
        for (Integer key : controlador.doctores.keySet()) {
            Doctor currentDoctor = controlador.doctores.get(key);
            System.out.println("");
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentDoctor.getNombre());
            System.out.println("Apellido: " + currentDoctor.getApellido());
            System.out.println("Edad: " + currentDoctor.getEdad());
            System.out.println("Dorsal: " + currentDoctor.getTitulo());
            System.out.println("Posición: " + currentDoctor.getExpYear());
        }
        ConsoleUtils.waitWindow();
    }
}
