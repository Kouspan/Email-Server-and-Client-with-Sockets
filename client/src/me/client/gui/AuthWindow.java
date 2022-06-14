package me.client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthWindow extends Window {
    private JPanel mainPanel;

    private JButton registerButton;
    private JButton loginButton;
    private JPanel buttonPanel;
    private JTextField userField;
    private JPasswordField passField;
    private JLabel userText;
    private JLabel passTest;
    private JLabel statusLabel;

    public AuthWindow(){
        super("Welcome");
        statusLabel.setForeground(Color.RED);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    public void show() {
        super.show(mainPanel);
    }

    public void hide(){
        frame.dispose();
    }


    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }


}
