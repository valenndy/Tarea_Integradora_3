package model;

public class Server {
    
    private double cache;
    private int numProcessor;
    private String MarkProcessor;
    private double ram;
    private int disc;
    private double CapacityDisc;


    public Server(double cache, int numProcessor, String MarkProcessor, double ram, int disc, double CapacityDisc) {
        this.cache = cache;
        this.numProcessor = numProcessor;
        this.MarkProcessor = MarkProcessor;
        this.ram = ram;
        this.disc = disc;
        this.CapacityDisc = CapacityDisc;
    }


    public double getCache() {
        return this.cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public int getNumProcessor() {
        return this.numProcessor;
    }

    public void setNumProcessor(int numProcessor) {
        this.numProcessor = numProcessor;
    }

    public String getMarkProcessor() {
        return this.MarkProcessor;
    }

    public void setMarkProcessor(String MarkProcessor) {
        this.MarkProcessor = MarkProcessor;
    }

    public double getRam() {
        return this.ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public int getDisc() {
        return this.disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public double getCapacityDisc() {
        return this.CapacityDisc;
    }

    public void setCapacityDisc(double CapacityDisc) {
        this.CapacityDisc = CapacityDisc;
    }



    


}
