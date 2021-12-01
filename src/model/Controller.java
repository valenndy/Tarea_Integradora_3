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

    }

    public String infoAvailableRooms() {
        String message = "";

        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                MiniRoom aux=miniRooms[i][j];
                if (aux.isRent()==false) {
                    message+=aux.toString()+"\n";
                }

            }
        }
        
        return message;
    }

    public String rentAMiniroom(int num, String name, String nit, ArrayList<Server> rack) {
        MiniRoom room=searchRoom(num);
        room.setCompany(new Company(name, nit));
        room.setRack(rack);
        room.setRent(true);

        return "Rent a mini-room success";

    }

    public MiniRoom searchRoom(int num){
        MiniRoom room=null;
        for (int i = 0; i < miniRooms.length; i++) {
            for (int j = 0; j < miniRooms[0].length; j++) {
                boolean find = false;
                if (miniRooms[i][j].getNum()==num) {
                    find=true;
                   room=miniRooms[i][j];
                }
        }
    }
    return room;
    }

}
