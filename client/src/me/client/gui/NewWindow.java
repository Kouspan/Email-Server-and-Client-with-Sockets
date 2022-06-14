package me.client.gui;

import javax.swing.*;

public class NewWindow extends Window {

    private JPanel mainPanel;
    private JTextArea bodyText;
    private JButton closeButton;
    private JPanel buttonPanel;
    private JScrollPane bodyScrollPanel;
    private JPanel detailsPanel;
    private JTextField receiverText;
    private JTextField subjectText;
    private JLabel fromLabel;
    private JLabel subjectButton;
    private JLabel toButton;
    private JLabel senderLabel;
    private JButton sendButton;

    public NewWindow() {
        super("New Email");
        bodyText.setLineWrap(true);
        bodyText.setWrapStyleWord(true);

    }

    public void show(String sender) {
        senderLabel.setText(sender);
        receiverText.setText("");
        subjectText.setText("");
        bodyText.setText("");
        super.show(mainPanel);
        super.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JTextArea getBodyText() {
        return bodyText;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JTextField getReceiverText() {
        return receiverText;
    }

    public JTextField getSubjectText() {
        return subjectText;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JLabel getSenderLabel() {
        return senderLabel;
    }
}
