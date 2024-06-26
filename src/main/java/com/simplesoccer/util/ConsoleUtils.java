package com.simplesoccer.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitWindow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Presiona enter para continuar");
        sc.nextLine();
        sc.close();
    }

    public static int verificarEntradaInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (true) {
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion >= min && opcion <= max) {
                    break; 
                } else {
                    System.out.println("Opción no válida. Por favor, elija una opción entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre " + min + " y " + max + ".");
                sc.nextLine(); 
            }
        }

        sc.close();
        return opcion;
    }

    public static String verificarEntradaString() {
        Scanner sc = new Scanner(System.in);
        String entrada = "";

        while (true) {
            entrada = sc.nextLine().trim(); 
            if (!entrada.isEmpty()) {
                break; 
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese una cadena no vacía.");
            }
        }

        sc.close();
        return entrada; 
        
    }
    
    public static int verificarIntSinRango(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                opcion = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.next();  
            }
        }

        sc.close();
        return opcion;
    }
}