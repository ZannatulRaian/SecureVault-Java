=====================================================
                 SECUREVAULT - JAVA
             Password Manager (GUI & Terminal)
=====================================================

SecureVault is a lightweight and secure password manager written in Java.
It allows you to store, view, update, and delete credentials safely.
All credentials are encrypted using AES encryption.

Features:
---------
- Master password protection (default: admin)
- Add, update, delete, and view credentials
- AES encrypted storage
- GUI version using Java Swing
- Terminal version for lightweight usage
- Customizable window icon for GUI

Screenshots:
------------
GUI Version:
<img width="333" height="152" alt="Screenshot 2025-12-19 141325" src="https://github.com/user-attachments/assets/5ea7a676-b749-4a05-ab7c-edd57965e1ed" />
<img width="601" height="538" alt="Screenshot 2025-12-19 142237" src="https://github.com/user-attachments/assets/b61b0e44-d123-497b-9a2d-2bbf2cabc7e9" />

Terminal Version:
--------------------------------
Welcome to SecureVault
Enter Master Password: ****
Access Granted!
--- Menu ---
1. Add Credential
2. View All
3. Update Credential
4. Delete Credential
5. Exit
Choose an option:
--------------------------------

Getting Started:
----------------
Prerequisites:
- Java JDK 11 or above
- Any IDE (VS Code, IntelliJ IDEA, Eclipse) or terminal

Files Included:
---------------
- Credential.java        -> Credential class
- Vault.java             -> Vault for storing credentials
- CryptoUtils.java       -> AES encryption utilities
- SecureVaultUI.java     -> GUI version
- Main.java              -> Terminal version
- SecureVaultIcon.png    -> Custom icon for GUI

Running the GUI Version:
------------------------
1. Place 'SecureVaultIcon.png' in the same folder as your Java files
2. Compile all Java files:
   javac *.java
3. Run the GUI:
   java SecureVaultUI
4. Enter master password ('admin')
5. Use input fields to add, update, or delete credentials
6. Click 'Exit' to close the app safely

Running the Terminal Version:
-----------------------------
1. Compile all Java files:
   javac *.java
2. Run the terminal version:
   java Main
3. Enter master password ('admin')
4. Use menu options:
   1 -> Add Credential
   2 -> View All
   3 -> Update Credential
   4 -> Delete Credential
   5 -> Exit

Encryption Details:
-------------------
- AES encryption with 16-byte key: 1234567887654321
- Credentials stored in 'credentials.dat'
- Decrypted only in memory when viewing or editing

Contributing:
-------------
Contributions welcome! Ideas:
- Copy password to clipboard
- Password strength checker
- Show/hide password toggle
- Dark mode for GUI

License:
--------
MIT License – Free to use and modify.

=====================================================
