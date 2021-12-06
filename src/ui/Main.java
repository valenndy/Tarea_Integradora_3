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
     * Descripción: Menu de opciones</br>
     */
    public int showMenuAndGetOption() {
        System.out.println("\n\nMENU, Input a option\n"
                + "(1) Show list of available mini-rooms\n"
                + "(2) Rent a mini-room\n"
                + "(3) Cancel rent a mini room \n"
                + "(4) Show status of mini-rooms \n"
                + "(5) Show the map of the mini-rooms \n"
                + "(6) simulate the turning on of all rooms \n"
                + "(7) simulate turning off all rooms according to the letter entered \n"
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
                rentAMiniroom();
                break;
            case 3:
                cancelRentAMiniRoom();

                break;
            case 4:
                System.out.println(controller.infoStatusRooms());

                break;
            case 5:
                System.out.println(showMap());
                break;

            case 6:
                simulateOn();
                break;

            case 7:
                simulateOff();
                break;
        }
    }


    private void cancelRentAMiniRoom() {

        System.out.println(" 1 To delete mini-rooms for company, 2 To delete mini-room for ID");
        int option = Integer.parseInt(sc.nextLine());

        if (option == 1) {
            System.out.println("input the name of company: ");
            String name = sc.nextLine();
            System.out.println(controller.cancelRentAMiniRoom(name));
        } else if (option == 2) {
            System.out.println("Input the ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println(controller.cancelRentAMiniRoom(id));
        }

    }

    private void rentAMiniroom() {
        System.out.println("Input the number of miniroom to rent: ");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("Select 1 for private company or 2 for research project: ");
        int option = Integer.parseInt(sc.nextLine());

        if (option == 1 || option == 2) {
            String name;
            String nit;
            if (option == 1) {
                System.out.println("The name of company: ");
                name = sc.nextLine();

                System.out.println("The nit of company: ");
                nit = sc.nextLine();
            } else {
                name = "ICESI";
                System.out.println("Input the ID of research project: ");
                nit = sc.nextLine();
            }
            System.out.println("Input the amount of servers: ");
            int numServes = Integer.parseInt(sc.nextLine());

            ArrayList<Server> rack = new ArrayList<>();
            for (int i = 0; i < numServes; i++) {
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

        } else {
            System.out.println("invalid option");
        }
    }

    private void infoAvailableRooms() {
        System.out.println(controller.infoAvailableRooms());
    }

    private String showMap() {
        return controller.showMap();
    }

    private void simulateOff() {
        /*
         * Letter L: turn off the first mini-quarters of all runners, along with the
         * mini-quarters of the first runner.
         * 
         * Letter Z: turn off the mini-quarters of the first and last runner, along with
         * the mini-quarters of the reverse diagonal.
         * 
         * Letter H: turn off the mini-rooms located in the odd-numbered corridors
         * 
         * Letter O: turn off the mini-rooms located in the windows
         * 
         * Letter M: Asks the user for a column N and turns off all mini-rooms in column
         * N
         * 
         * Letter P: turn off the mini-rooms of a corridor (given the corridor. Remember
         * that for the user, corridors start in one)
         */

        int x = 0;
        System.out.println("Input the letter of simulation system");
        String letter = sc.nextLine();

        if (letter.equals("M") || letter.equals("P")) {
            x = Integer.parseInt(sc.nextLine());
        }

        System.out.println(controller.simulateOff(letter, x));

    }

    private void simulateOn() {
        System.out.println(controller.simulateOn());

    }



}
