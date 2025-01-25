import java.util.Random;

public class MobEnemy {
    private Player player;
    private int combatPoints;

    public MobEnemy(Player player) {
        this.player = player;
        this.combatPoints = 7;
    }

    public void enemyEncounter() {
        Random enemy = new Random();
        int enemyNo = enemy.nextInt(4);
        switch (enemyNo) {
            case 1:
                slime();
                break;

            case 2:
                wolf();
                break;
            case 3:
                bear();
                break;
            case 4:
                theif();
                break;
            default:
                break;
        }
    }

    private void slime() {
        System.out.println("You Encountered a Slime !!");
        int result = this.player.getCombatPoints() > this.combatPoints ? 1 : 2;

        if (result == 1) {
            System.out.println("You attacked the slime!");
            System.out.println("Slime used bump!");
            this.player.decreaseHealth(1);
            System.out.println("You attack the slime");
            System.out.println("Victory!!");
            this.player.increaseMoney(5);
        } else {

            while (true) {
                if (!this.player.checkStatus()) {
                    break;
                }
                System.out.println("You attacked the slime!");
                System.out.println("Slime used bump!");
                this.player.decreaseHealth(1);
                System.out.println("You attack the slime");
                System.out.println("Slime attacks again");
                this.player.decreaseHealth(2);
                System.out.println("Slime attacks");
                this.player.decreaseHealth(3);
                System.out.println("Defeat!!");
            }
        }
    }

    private void theif() {

        System.out.println("You Encountered a thief !!");
        int result = new Random().nextInt(2);
        if (result == 1) {
            System.out.println("You attacked the thief!");
            System.out.println("thief used stab!");
            this.player.decreaseHealth(1);
            System.out.println("You attack the thief");
            System.out.println("Victory!!");
            this.player.increaseMoney(5);
        } else {

            while (true) {
                if (!this.player.checkStatus()) {
                    break;
                }
                System.out.println("You attacked the thief!");
                System.out.println("thief used bump!");
                this.player.decreaseHealth(1);
                System.out.println("You attack the thief");
                System.out.println("thief attacks again");
                this.player.decreaseHealth(2);
                System.out.println("thief attacks");
                this.player.decreaseHealth(3);
                System.out.println("Defeat!!");
            }
        }
    }

    private void wolf() {

        System.out.println("You Encountered a wolf !!");
        int result = new Random().nextInt(2);
        if (result == 1) {
            System.out.println("You attacked the wolf!");
            System.out.println("wolf used bump!");
            this.player.decreaseHealth(1);
            System.out.println("You attack the wolf");
            System.out.println("Victory!!");
            this.player.increaseMoney(5);
        } else {

            while (true) {
                if (!this.player.checkStatus()) {
                    break;
                }
                System.out.println("You attacked the wolf!");
                System.out.println("wolf used bite!");
                this.player.decreaseHealth(1);
                System.out.println("You attack the wolf");
                System.out.println("wolf attacks again");
                this.player.decreaseHealth(2);
                System.out.println("wolf attacks");
                this.player.decreaseHealth(3);
                System.out.println("Defeat!!");
            }
        }
    }

    private void bear() {

        System.out.println("You Encountered a bear !!");
        int result = new Random().nextInt(2);
        if (result == 1) {
            System.out.println("You attacked the bear!");
            System.out.println("bear used bump!");
            this.player.decreaseHealth(1);
            System.out.println("You attack the bear");
            System.out.println("Victory!!");
            this.player.increaseMoney(5);
        } else {

            while (true) {
                if (!this.player.checkStatus()) {
                    break;
                }
                System.out.println("You attacked the bear!");
                System.out.println("bear used slash!");
                this.player.decreaseHealth(1);
                System.out.println("You attack the bear");
                System.out.println("bear attacks again");
                this.player.decreaseHealth(2);
                System.out.println("bear attacks");
                this.player.decreaseHealth(3);
                System.out.println("Defeat!!");
            }
        }
    }

}
