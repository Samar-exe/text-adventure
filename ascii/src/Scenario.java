import java.util.Random;
import java.util.Scanner;

public class Scenario {
    private Player player;
    private Scanner sc;

    public Scenario(Player player, Scanner sc) {
        this.player = player;
        this.sc = sc;
    }

    public void startScenario() {
        int scenarioNumber = new Random().nextInt(4);
        switch (scenarioNumber) {
            case 0:
                scenarioOne();
                break;
            case 1:
                scenarioTwo();
                break;
            case 2:
                scenarioThree();
                break;
            case 3:
                scenarioFour();
                break;
            default:
                break;
        }
    }

    private void scenarioOne() {
        int combatPoints = 5;
        System.out.println("Scenario One: You find a hidden treasure chest!");
        System.out.println("You open the chest and find a sword inside.");
        System.out.println("2: No");
        int choice = Integer.valueOf(sc.nextLine());
        if (choice == 1) {
            System.out.println("You have equiped 'Imperial Soldier's Sword.");
            player.increaseCombatPoints(combatPoints);
            System.out.println("Your combat points have increased to " + player.getCombatPoints());
        } else {
            System.out.println("You leave the sword behind.");
        }
    }

    private void scenarioTwo() {
        System.out.println("Scenario Two: You encounter a wandering merchant.");
        System.out.println("Items: ");
        System.out.println("1: Small Health Potion (5 zions)");
        System.out.println("2: Big Health Potion (9 zions)");
        System.out.println("3: Exit");
        while (true) {
            int choice = Integer.valueOf(sc.nextLine());
            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("You have purchased a Small Health Potion.");
                    player.increaseHealth();
                    player.decreaseMoney(5);
                    System.out.println("Your health has increased to " + player.getHealth());
                    break;
                case 2:
                    System.out.println("You have purchased a Big Health Potion.");
                    player.decreaseMoney(9);
                    player.increaseHealth();
                    System.out.println("Your health has increased to " + player.getHealth());
                    break;
                default:
                    break;
            }
        }
    }

    private void scenarioThree() {
        int combatPoints = 8;
        System.out.println("Scenario Three: You fall into a trap set by bandits.");
        System.out.println("You are attacked by bandits!");
        int result = this.player.getCombatPoints() > combatPoints ? 1 : 2;
        if (result == 1) {
            System.out.println("You have defeated the bandits!");
            player.increaseMoney(10);
            System.out.println("You have looted 10 zions from the bandits.");
        } else {
            System.out.println("You run away from the bandits.");
        }
    }

    private void scenarioFour() {
        System.out.println("Scenario Four: You discover an ancient ruin.");
        System.out.println("You have discovered an ancient ruin. Would you like to explore it?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int choice = Integer.valueOf(sc.nextLine());
        if (choice == 1) {
            System.out.println("You enter the ancient ruin and find a hidden room.");
            System.out.println("You find a mysterious artifact inside the room.");
            System.out.println("1: Take the artifact");
            System.out.println("2: Leave it");
            choice = Integer.valueOf(sc.nextLine());
            if (choice == 1) {
                System.out.println("You have taken the mysterious artifact.");
                System.out.println("You feel a surge of power within you.");
                player.increaseCombatPoints(3);
                System.out.println("Your combat points have increased to " + player.getCombatPoints());

                System.out.println("The floor beneath you begins to shake.");
                System.out.println("The floor collapses and you fall into a hidden chamber.");
                System.out.println("You encounter a powerful guardian.");
                System.out.println("You must defeat the guardian to escape the ancient ruin.");
                int guardianCombatPoints = 10;
                int result = this.player.getCombatPoints() > guardianCombatPoints ? 1 : 2;
                if (result == 1) {
                    System.out.println("You have defeated the guardian!");
                    player.increaseMoney(20);
                    System.out.println("You have looted 20 zions from the guardian.");
                } else {
                    System.out.println("You have been defeated by the guardian!");
                    player.decreaseHealth(3);
                    System.out.println("Your health has decreased to " + player.getHealth());
                }
            } else {
                System.out.println("You leave the artifact behind.");
            }
        } else {
            System.out.println("You decide not to explore the ancient ruin.");
        }
    }
}
