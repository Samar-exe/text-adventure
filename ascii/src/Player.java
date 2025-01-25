import java.util.ArrayList;

public class Player {
    private String name;
    private String character;
    private int health;
    private ArrayList<String> inventory;

    public void setCharacter(String character, String name) {
        this.character = character;
        this.name = name;
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
        return String.format("Name: %s\nHealth: %d\nRole: %s", this.name, this.health, this.character);
    }
}
