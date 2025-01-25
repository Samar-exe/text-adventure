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
        this.alive = true;
        this.NAME = name;
        this.ROLE = role;
        this.health = 5;
        this.money = 20;
        this.combatPoints = 5;
    }

    public void increaseCombatPoints(int amount) {
        this.combatPoints += amount;
    }

    public void decreaseCombatPoints(int amount) {
        this.combatPoints -= amount;
    }

    public int getCombatPoints() {
        return this.combatPoints;
    }

    public void increaseHealth() {
        if (this.health < 5) {
            this.health++;
        }
    }

    public boolean checkStatus() {
        return this.alive;
    }

    public void decreaseHealth(int amount) {
        if ((this.health - amount) > 0) {
            this.health -= amount;
        } else {
            this.health = 0;
            this.alive = false;
        }
    }

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void decreaseMoney(int amount) {
        this.money -= amount;
    }

    public boolean checkMoney(int deduct) {
        if (this.money > 0) {
            if (this.money - deduct >= 0) {
                return true;
            } else {
                System.out.println("not enough Money");
                return false;
            }
        }
        System.out.println("No money");
        return false;
    }

    public void addItem(String item) {
        this.inventory.add(item);
    }

    public String toString() {
        System.out.println();
        StringBuilder items = new StringBuilder();
        for (String item : this.inventory) {
            items.append(item + "\n");
        }
        return String.format("Name: %s\nHealth: %d\nRole: %s\nMoney: %d\nItems:\n%s", this.NAME, this.health, this.ROLE,
                this.money, items);
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
