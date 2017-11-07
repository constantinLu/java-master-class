package MasterClass.composition;

public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard Motherboard;


    public Case getTheCase() {
        return theCase;
    }

    public void setTheCase(Case theCase) {
        this.theCase = theCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Motherboard getMotherboard() {
        return Motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        Motherboard = motherboard;
    }


}
