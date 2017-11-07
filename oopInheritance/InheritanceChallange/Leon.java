package MasterClass.InheritanceEx;

public class Leon extends Car {

    private int roadService;

    public Leon(int roadService) {
        super("Leon", "2WD", 5, 5, 6, false);
        this.roadService = roadService;
    }

    // rate is the difference in speed from the current speed
    public void accelerate(int rate) {

        int newVelocity = getCurrentVelocity() + rate;  // rate can be - or + , acc or decc
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 40) {
            changeGear(2);
        } else if (newVelocity > 40 && newVelocity <= 60) {
            changeGear(3);
        } else {
            changeGear(4);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }


}
