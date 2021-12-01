package model;

public class Company {
    private String name;
    private int nit;



    public Company(String name, int nit) {
        this.name = name;
        this.nit = nit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return this.nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }



}
