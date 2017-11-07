package MasterClass.oopInheritance;

// inheritance
public class Animal {

    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    //constructor
    public Animal(String name, int brain, int body, int size, int weight) {
        super();
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // behavior for all animals
    public void eat() {
        System.out.println("Animal eat() called");
    }

    public void move(int speed) {
        System.out.println("Animal.move() called.  Animal is moving at : " + speed);

    }


}
