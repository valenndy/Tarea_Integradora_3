package model;

import java.util.ArrayList;

public class Controller {

    private MiniRoom[][] miniRooms;

    public Controller() {
        this.miniRooms = new MiniRoom[8][50];
        createMiniRooms();
    }

    public void createMiniRooms() {
        int num = 1;

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                boolean window = false;
                if (i == 0 || i == 7 || j == 0 || j == 49) {
                    window = true;
                }

                miniRooms[i][j] = new MiniRoom(num, j, i, window);
                num++;
            }
        }

        miniRooms[7][49].setStatus(true);

    }

    public String infoAvailableRooms() {
        String message = "";

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom aux = miniRooms[i][j];
                if (aux.isRent() == false) {
                    message += aux.toString() + "\n";
                }

            }
        }

        return message;
    }

    public String infoStatusRooms() {
        String message = "";

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom aux = miniRooms[i][j];
                if (aux.isRent() == false) {
                    message += "-----------------------------------\n" + aux.toStringStatus() + "\n";
                }

            }
        }

        return message;
    }

    public String rentAMiniroom(int num, String name, String nit, ArrayList<Server> rack) {
        MiniRoom room = searchRoom(num);
        room.setCompany(new Company(name, nit));
        room.setRack(rack);
        room.setRent(true);

        return "Rent a mini-room success";

    }

    public MiniRoom searchRoom(int num) {
        MiniRoom room = null;
        boolean find = false;
        for (int i = 0; i < miniRooms.length && !find; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                if (miniRooms[i][j].getNum() == num) {
                    find = true;
                    room = miniRooms[i][j];
                }
            }
        }
        return room;
    }

    public String cancelRentAMiniRoom(int id) {
        String message = "The mini room doesn't exist";
        if (searchRoom(id) != null) {
            MiniRoom mini = searchRoom(id);
            double proccesCapacity = mini.cancelRent();
            message = "The mini room has been canceled rent successfully and your procces capacity is :"
                    + proccesCapacity;
        }
        return message;
    }

    public String cancelRentAMiniRoom(String name) {
        boolean cancel = false;
        double proccesCapacity = 0;
        String message = "The company don't have rent a mini-rooms";
        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                if (miniRooms[i][j].getCompany() != null) {
                    if (miniRooms[i][j].getCompany().getName().equals(name)) {
                        proccesCapacity += miniRooms[i][j].cancelRent();
                        cancel = true;
                    }
                }
            }
        }
        if (cancel == true) {
            message = "The mini rooms has been canceled rent successfully and your procces capacity is :" + proccesCapacity;
        }

        return message;
    }

    public String showMap() {

        String message = "";

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {

                message += " [" + miniRooms[i][j].getNum() + ": " + miniRooms[i][j].getStatus() + "] ";
            }
            message += "\n";
        }
        return message;

    }

    public String simulateOn() {
        String message = "TURN ON THE MINI-ROOMS";

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom miniroom = miniRooms[i][j];
                miniroom.setStatus(true);

            }
        }

        message += showMap();

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom miniroom = miniRooms[i][j];
                if (miniroom.getRent() == false) {
                    miniroom.setStatus(false);
                }

            }
        }

        return message;

    }

    public String simulateOff(String letter, int x) {
        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom miniroom = miniRooms[i][j];
                miniroom.setStatus(true);

            }
        }

        String message = "";
        letter = letter.toUpperCase();

        switch (letter) {
            case "L":

                for (int j = 0; j < miniRooms[0].length; j++) {
                    miniRooms[0][j].setStatus(false);
                }
                for (int i = 0; i < miniRooms.length; i++) {
                    miniRooms[i][0].setStatus(false);
                }

                message += showMap();

                break;
            case "Z":
                for (int i = 0; i < miniRooms.length; i++) {
                    for (int j = 0; j < miniRooms[0].length; j++) {
                        MiniRoom miniroom = miniRooms[i][j];

                        if ((i + 1) % 2 != 0) {
                            miniroom.setStatus(false);
                        }

                    }
                }

                message += showMap();

                break;
            case "H":

                for (int i = 0; i < miniRooms.length; i++) {
                    for (int j = 0; j < miniRooms[0].length; j++) {
                        MiniRoom miniroom = miniRooms[i][j];

                        if ((i + 1) % 2 != 0) {
                            miniroom.setStatus(false);
                        }

                    }
                }

                message += showMap();

                break;
            case "O":

                for (int i = 0; i < miniRooms.length; i++) {
                    for (int j = 0; j < miniRooms[0].length; j++) {
                        MiniRoom miniroom = miniRooms[i][j];

                        if (miniroom.isWindow() == true) {
                            miniroom.setStatus(false);
                        }

                    }
                }

                message += showMap();

                break;
            case "M":
                for (int i = 0; i < miniRooms.length; i++) {
                    miniRooms[i][x - 1].setStatus(false);
                }

                message += showMap();

                break;
            case "P":

                for (int j = 0; j < miniRooms[0].length; j++) {
                    miniRooms[x - 1][j].setStatus(false);
                }

                message += showMap();

                break;

            default:
                message = "The letter is not a simulation system ";
                break;
        }

        return message;
    }

}
