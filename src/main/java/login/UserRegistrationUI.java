package login;

import javax.swing.*;

public class UserRegistrationUI {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("User Registration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Tạo nhãn Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        frame.add(usernameLabel);

        // Tạo trường nhập Username
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        frame.add(usernameField);

        // Tạo nhãn Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        frame.add(passwordLabel);

        // Tạo trường nhập Password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        frame.add(passwordField);

        // Tạo nút đăng ký
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 150, 100, 30);
        frame.add(registerButton);

        // Tạo nhãn kết quả
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 200, 300, 30);
        frame.add(resultLabel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}

