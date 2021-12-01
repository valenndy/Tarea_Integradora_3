package model;

public class MiniRoom {

    private int num;
    private double price;
    private boolean rent;
    private int colum;
    private int row;
    private boolean window;
    


    public MiniRoom(int num,int colum,int row,boolean window) {
        this.num = num;
        this.price = 0;
        this.rent = false;
        this.row=row;
        this.colum=colum;
        this.window=window;
    }

    //TODO insert method for calculate rent


    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public boolean isRent() {
        return this.rent;
    }

    public boolean getRent() {
        return this.rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public int getColum() {
        return this.colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isWindow() {
        return this.window;
    }

    public boolean getWindow() {
        return this.window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }
    


    @Override
    public String toString() {
        return 
            "the num: " + getNum() + "\n" +
            "the price: " + getPrice() + "\n" +
            "the rent: " + isRent() + "\n" +
            "the colum: " + getColum() + "\n" +
            "the row: " + getRow() + "\n" +
            "the window: " + isWindow() + "\n";
    }

   



    
}