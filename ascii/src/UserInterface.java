import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Runtime;

public class UserInterface {
    private MobEnemy mobEnemy;
    private Scanner sc;
    private Player player;
    private HashMap<Integer, String> roles;
    private Scenario scenario;

    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.player = new Player();
        this.roles = new HashMap<>();
        roles.put(1, "Knight");
        roles.put(2, "Mage");
        roles.put(3, "Mercenary");
        roles.put(4, "Ranger");
        this.mobEnemy = new MobEnemy(this.player);
        this.scenario = new Scenario(this.player, this.sc);
    }

    public void start() {
        WelcomeScreen();
        characterCreation();
        System.out.println(this.player);

        // start an adventure based on the role selected
        switch (this.player.getROLE()) {
            case "Knight":
                knightAdventure();
                break;
            case "Mage":
                break;

            case "Mercenary":
                break;

            case "Ranger":
                break;

            default:
                break;
        }
    }

    private void knightAdventure() {
        int choice;
        System.out.println("\nYou Choose to be an aspiring Knight, May the Glory of your predecessors be with you.");
        while (true) {

            System.out.println("\nYou arrive at a blacksmiths store\n1:Shop\n2:Move Ahead");
            choice = Integer.valueOf(sc.nextLine());
            if (choice == 1) {
                System.out.println("Items");
                System.out.println(
                        "1: Beginner's Sword (5 zions)\n2: Beginner's Helmet (2 zions)\n3: Beginner's Sheild (3 zions)\n4: Exit");
                while (true) {
                    choice = Integer.valueOf(sc.nextLine());
                    if (choice == 1) {
                        if (this.player.checkMoney(5)) {
                            this.player.decreaseMoney(5);
                            this.player.addItem("Beginner's Sword");
                            this.player.increaseCombatPoints(1);
                        }
                    }
                    if (choice == 2) {
                        if (this.player.checkMoney(2)) {
                            this.player.decreaseMoney(2);
                            this.player.addItem("Beginner's Helmet");
                            this.player.increaseCombatPoints(1);
                        }
                    }
                    if (choice == 3) {
                        if (this.player.checkMoney(3)) {
                            this.player.decreaseMoney(3);
                            this.player.addItem("Beginner's Shield");
                            this.player.increaseCombatPoints(1);
                        }
                    }
                    if (choice == 4) {
                        break;
                    }
                }
                System.out.println(this.player);
            } else {
                System.out.println("\nYou continue your adventure");
            }
            mobEnemy.enemyEncounter();
            if (!this.player.checkStatus()) {
                break;
            }
            this.scenario.startScenario();
            if(!this.player.checkStatus()){
                break;
            }
        }

        System.out.println("Game Over");
    }

    private void mageAdventure() {

    }

    private void mercenaryAdventure() {

    }

    private void rangerAdventure() {

    }

    private void characterCreation() {

        String name;
        String role;
        // Choose name
        System.out.print("Enter Name of your character: ");
        while (true) {
            name = this.sc.nextLine();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Please Enter a name");
        }

        System.out.println("From here on Enter you choices option number");

        System.out.println("Select one of the following Role :\n1: Knight\n2: Mage\n3: Mercenary\n4: Ranger");
        while (true) {
            int option = Integer.valueOf(sc.nextLine());
            if (this.roles.containsKey(option)) {
                role = this.roles.get(option);
                break;
            }
            System.out.println("Please select a valid Role");
        }
        this.player.setCharacter(role, name);
    }

    private void WelcomeScreen() {
        try {
            Process p = Runtime.getRuntime().exec("figlet Txt Adventure");
            String s;
            BufferedReader read = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = read.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {

        }
    }
}
