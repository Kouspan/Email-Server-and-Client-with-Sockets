package me.client.gui;

import me.common.code.Email;
import javax.swing.*;
import java.util.ArrayList;

public class HomeWindow extends Window {
    private JPanel mainPanel;

    private JTable mailTable;
    private JButton newButton;
    private JButton readButton;
    private JButton fetchButton;
    private JButton deleteButton;
    private JPanel buttonPanel;
    private JScrollPane scrollPane;
    private JButton exitButton;
    private JButton logOutButton;
    TableModelWrapper tableModel;

    public HomeWindow() {
        super("Home");
        tableModel = new TableModelWrapper();
    }

    public void show(ArrayList<Email> emails) {
        update(emails);
        mailTable.setModel(tableModel);
        mailTable.setAutoCreateRowSorter(false);
        mailTable.getColumnModel().getColumn(0).setMinWidth(60);
        mailTable.getColumnModel().getColumn(0).setMaxWidth(60);
        super.show(mainPanel);
    }

    public void update(ArrayList<Email> emails) {
        if(tableModel.getRowCount()>0){
            for(int i = tableModel.getRowCount()-1;i>-1;i--)
                tableModel.removeRow(i);
        }
        for (Email email : emails)
            addEmail(email);


    }
    public void addEmail(Email email){
        String readData = email.isNew() ? "*" : "";
        String[] data = {readData,email.getSender(),email.getSubject()};
        tableModel.addRow(data);

    }

    public JButton getNewButton() {
        return newButton;
    }

    public JButton getReadButton() {
        return readButton;
    }

    public JButton getFetchButton() {
        return fetchButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public TableModelWrapper getTableModel(){
        return tableModel;
    }

    public JTable getTable() {
        return mailTable;

    }
}
