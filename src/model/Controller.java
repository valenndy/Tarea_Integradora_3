package model;

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

}
