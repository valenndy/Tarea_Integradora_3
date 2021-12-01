package ui;

import java.util.Scanner;

import model.Controller;

public class Main {
    private Scanner sc;
    private Controller controller;

    public Main() {
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) {

        Main obPpal = new Main();

        int option = 0;

        do {
            option = obPpal.showMenuAndGetOption();
            obPpal.answerOption(option);
        } while (option != 0);

    }

    /**
     * Descripción:Menu de opciones</br>
     */
    public int showMenuAndGetOption() {
        System.out.println("\n\nMENU, Input a option\n" 
                + "(1) Show list of available mini-rooms\n"
                + "(2)\n"
                + "(3) \n"
                + "(4) \n" 
                + "(5) \n"
                + "(6) \n" 
                + "(7) \n"
                + "(8) \n" 
                + "(9) \n" 
                + "(0) EXIT");
        int input = Integer.parseInt(sc.nextLine());
        return input;

      

    }

    /**
     * Descripción: de acuerdo a la seleccion del usuario se dirige al metodo que
     * realiza la accion seleccionada</br>
     * 
     * @param <userOption> <String> debe ser un numero entero
     */
    public void answerOption(int userOption) {

        switch (userOption) {
        case 0:
            System.out.println("Close the app, bye.");
            break;
        case 1:
            infoAvailableRooms();
            break;
        case 2:
            
            break;
        case 3:
            
            break;
        case 4:
            
            break;
        case 5:
            
            break;

        case 6:
            
            break;

        case 7:
            
            break;

        case 8:
            
            break;

        case 9:
            
            break;

        }
    }

    private void infoAvailableRooms() {
        System.out.println(controller.infoAvailableRooms());
    }

   

    

}
