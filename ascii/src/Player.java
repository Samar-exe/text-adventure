import java.util.ArrayList;

public class Player {
    private String NAME;
    private String ROLE;
    private int health;
    private ArrayList<String> inventory;
    private int money;
    private boolean alive;
    private int combatPoints;

    public Player() {
        this.inventory = new ArrayList<>();
    }

    public void setCharacter(String role, String name) {
        this.NAME = name;
        this.ROLE = role;
        this.health = 5;
    }

    public void increaseHealth() {
        if (this.health < 5) {
            this.health++;
        }
    }

    public void addItem(String item) {
        this.inventory.add(item);
    }


    public String toString() {
        System.out.println();
        return String.format("Name: %s\nHealth: %d\nRole: %s", this.NAME, this.health, this.ROLE);
    }

    public String getNAME() {
        return NAME;
    }

    public String getROLE() {
        return ROLE;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }
}
