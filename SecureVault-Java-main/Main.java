import java.util.Scanner;
public class Main {
    private static final String MASTER_PASSWORD = "admin";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to SecureVault");
        System.out.print("Enter Master Password: ");
        String input = scanner.nextLine();
        if (!input.equals(MASTER_PASSWORD)) {
            System.out.println(" Access Denied. Wrong password.");
            return;
        }
        Vault vault = new Vault();
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Credential");
            System.out.println("2. View All");
            System.out.println("3. Update Credential");
            System.out.println("4. Delete Credential");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Website: ");
                    String website = scanner.nextLine();
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    vault.addCredential(new Credential(website, username, password));
                    System.out.println(" Saved!");
                    break;
                case 2:
                    vault.viewAll();
                    break;
                case 3:
                    vault.viewAll();
                    System.out.print("Enter index to update: ");
                    int updIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                    System.out.print("New Username: ");
                    String newUser = scanner.nextLine();
                    System.out.print("New Password: ");
                    String newPass = scanner.nextLine();
                    vault.updateCredential(updIndex, newUser, newPass);
                    break;
                case 4:
                    vault.viewAll();
                    System.out.print("Enter index to delete: ");
                    int delIndex = scanner.nextInt() - 1;
                    vault.deleteCredential(delIndex);
                    break;
                case 5:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}