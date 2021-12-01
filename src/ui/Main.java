package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Controller;
import model.Server;

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
        System.out.println("\n\nMENU, Input a option\n" + "(1) Show list of available mini-rooms\n" + "(2) Rent a mini-room\n" + "(3) \n"
                + "(4) \n" + "(5) \n" + "(6) \n" + "(7) \n" + "(8) \n" + "(9) \n" + "(0) EXIT");
        int input = Integer.parseInt(sc.nextLine());
        return input;

    }

    // Alquilar un minicuarto, aquí será importante dejar el registro de la fecha de
    // alquiler, registrar los servidores y calcular el valor del alquiler mensual
    // que una empresa debe pagar. Si el minicuarto se alquila a un proyecto de
    // investigación, la empresa es la universidad Icesi y se debe guardar además el
    // número de registro del proyecto.

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
            rentAMiniroom();
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

    private void rentAMiniroom() {
        System.out.println("Input the number of miniroom to rent: ");
        int num= Integer.parseInt(sc.nextLine());

        System.out.println("Select 1 for private company or 2 for research project: ");
        int option= Integer.parseInt(sc.nextLine());

        if (option == 1  || option == 2){
            String name;
            String nit;
            if (option == 1){
                System.out.println("The name of company: ");
                name = sc.nextLine();
   
               System.out.println("The nit of company: ");
                nit = sc.nextLine();
            }else{
                name = "ICESI";
                System.out.println("Input the ID of research project: ");
                nit = sc.nextLine();
            }
            System.out.println("Input the amount of servers: ");
            int numServes = Integer.parseInt(sc.nextLine());
            
            ArrayList <Server> rack = new ArrayList<>();
            for (int i=0;i < numServes; i++){
                System.out.println("Input the cache: ");
                double cache = Double.parseDouble(sc.nextLine());

                System.out.println("Input the number if processors: ");
                int numProcessor = Integer.parseInt(sc.nextLine());

                System.out.println("Input 1 if is intel or 2 if is AMD: ");
                int MarkProcessor = Integer.parseInt(sc.nextLine());

                System.out.println("Input the ram: ");
                double ram = Double.parseDouble(sc.nextLine());

                System.out.println("Input the disc");
                int disc = Integer.parseInt(sc.nextLine());

                System.out.println("Input the capacity of disc: ");
                double CapacityDisc = Integer.parseInt(sc.nextLine());

                rack.add(new Server(cache, numProcessor, MarkProcessor, ram, disc, CapacityDisc));
            }

            System.out.println(controller.rentAMiniroom(num, name, nit, rack));

      
            }else {
                System.out.println("invalid option");
            }
    }

    private void infoAvailableRooms() {
        System.out.println(controller.infoAvailableRooms());
    }

}
