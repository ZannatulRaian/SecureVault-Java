import java.awt.*;
import javax.swing.*;

public class SecureVaultUI {
    private Vault vault = new Vault();
    private JFrame frame;
    private JList<String> credentialList;
    private DefaultListModel<String> listModel;
    private JTextField websiteField, usernameField, passwordField;
    private JButton addButton, updateButton, deleteButton, exitButton;

    public SecureVaultUI() {
        // Master Password Prompt
        String password = JOptionPane.showInputDialog(null, "Enter Master Password:");
        if (!"admin".equals(password)) {
            JOptionPane.showMessageDialog(null, "Access Denied. Wrong password.");
            System.exit(0);
        }

        frame = new JFrame("SecureVault");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null); // center window

        // Set custom icon (replace "SecureVaultIcon.png" with your icon file)
        ImageIcon icon = new ImageIcon("SecureVaultIcon.jpg");
        frame.setIconImage(icon.getImage());

        // Credential List
        listModel = new DefaultListModel<>();
        credentialList = new JList<>(listModel);
        refreshList();
        frame.add(new JScrollPane(credentialList), BorderLayout.CENTER);

        // Input Panel with nicer layout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Website
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Website:"), gbc);
        gbc.gridx = 1;
        websiteField = new JTextField(20);
        inputPanel.add(websiteField, gbc);

        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(20);
        inputPanel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JTextField(20);
        inputPanel.add(passwordField, gbc);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addCredential());
        updateButton.addActionListener(e -> updateCredential());
        deleteButton.addActionListener(e -> deleteCredential());
        exitButton.addActionListener(e -> System.exit(0));

        // Click list item to fill fields
        credentialList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = credentialList.getSelectedIndex();
                if (index >= 0) {
                    Credential c = vault.getCredentials().get(index);
                    websiteField.setText(c.getWebsite());
                    usernameField.setText(c.getUsername());
                    passwordField.setText(c.getPassword());
                }
            }
        });

        frame.setVisible(true);
    }

    private void refreshList() {
        listModel.clear();
        for (Credential c : vault.getCredentials()) {
            listModel.addElement(c.getWebsite() + " | " + c.getUsername());
        }
    }

    private void addCredential() {
        if (websiteField.getText().isEmpty()) return;
        vault.addCredential(new Credential(
                websiteField.getText(),
                usernameField.getText(),
                passwordField.getText()
        ));
        refreshList();
        clearFields();
    }

    private void updateCredential() {
        int index = credentialList.getSelectedIndex();
        if (index >= 0) {
            vault.updateCredential(index, usernameField.getText(), passwordField.getText());
            refreshList();
            clearFields();
        }
    }

    private void deleteCredential() {
        int index = credentialList.getSelectedIndex();
        if (index >= 0) {
            vault.deleteCredential(index);
            refreshList();
            clearFields();
        }
    }

    private void clearFields() {
        websiteField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SecureVaultUI::new);
    }
}

