import java.io.*;
import java.util.*;

public class Vault {
    private static final String FILE_NAME = "credentials.dat";
    private List<Credential> credentials = new ArrayList<>();

    public Vault() {
        loadFromFile();
    }

    public void addCredential(Credential cred) {
        credentials.add(cred);
        saveToFile();
    }

    public void updateCredential(int index, String newUsername, String newPassword) {
        if (index >= 0 && index < credentials.size()) {
            Credential cred = credentials.get(index);
            cred.setUsername(newUsername);
            cred.setPassword(newPassword);
            saveToFile();
        }
    }

    public void deleteCredential(int index) {
        if (index >= 0 && index < credentials.size()) {
            credentials.remove(index);
            saveToFile();
        }
    }

    public List<Credential> getCredentials() {
        return new ArrayList<>(credentials); // return a copy
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Credential c : credentials) {
                String encrypted = CryptoUtils.encrypt(
                        c.getWebsite() + "," + c.getUsername() + "," + c.getPassword());
                writer.write(encrypted);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        credentials.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String decrypted = CryptoUtils.decrypt(line);
                    String[] parts = decrypted.split(",");
                    if (parts.length == 3) {
                        credentials.add(new Credential(parts[0], parts[1], parts[2]));
                    }
                } catch (Exception ex) {
                    System.out.println("Error decrypting a line, skipping.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}
