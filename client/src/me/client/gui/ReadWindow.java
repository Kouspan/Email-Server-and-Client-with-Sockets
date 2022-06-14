package me.client.gui;

import me.common.code.Email;

import javax.swing.*;

public class ReadWindow extends Window{
    private JTextArea bodyText;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JButton closeButton;
    private JLabel senderLabel;
    private JLabel receiverLabel;
    private JLabel subjectLabel;
    private JPanel detailsPanel;

    public ReadWindow() {
        super("Read Mail");
        bodyText.setEditable(false);
        bodyText.setLineWrap(true);
        bodyText.setWrapStyleWord(true);

    }
    public void show(Email email){
        bodyText.setText(email.getBody());
        subjectLabel.setText(email.getSubject());
        senderLabel.setText(email.getSender());
        receiverLabel.setText(email.getReceiver());
        super.show(mainPanel);
        super.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void hide(){
        frame.dispose();
    }

    public JButton getCloseButton() {
        return closeButton;
    }
}
