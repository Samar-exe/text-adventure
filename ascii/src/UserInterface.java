import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Runtime;

public class UserInterface {
    private Scanner sc;
    private Player player;
    private HashSet<String> roles;

    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.player = new Player();
        this.roles = new HashSet<>();
        roles.add("Knight");
        roles.add("Mage");
        roles.add("Mercenary");
        roles.add("Ranger");
    }

    public void start() {
        WelcomeScreen();
        characterCreation();
    }

    public void characterCreation() {
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

        System.out.print("Select one of the following Role : \n 1: Knight\n2: Mage\n 3: Mercenary\n4: Ranger");
        while (true) {
            role = sc.nextLine();
            if (this.roles.contains(role)) {
                break;
            }
            System.out.println("Please select a valid Role");
        }
        this.player.setCharacter(role, name);
    }

    public void WelcomeScreen() {
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
