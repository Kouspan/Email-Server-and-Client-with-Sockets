package me.client.code;

import me.client.gui.TableModelWrapper;
import me.client.gui.View;
import me.common.IRequest;
import me.common.IResponse;
import me.common.ResponseCode;
import me.common.Type;
import me.common.code.Account;
import me.common.code.Email;
import me.common.code.MailBox;
import me.common.requests.*;
import me.common.responses.EmailResponse;
import me.common.responses.LoginResponse;
import me.common.responses.RegisterResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private final View view;
    private Client client;

    public Controller(View view, Client client) {
        this.view = view;
        this.client = client;
        createListeners();

    }

    private void createListeners() {
        getNewButton().addActionListener(e -> launchNew(client.getAccount().getUsername()));

        getReadButton().addActionListener(e -> {
            int row = getTable().getSelectedRow();
            if (row != -1) {
                client.sendRequest(new ReadRequest(row));
                view.getHomeWindow().getTableModel().setValueAt("", row, 0);
                Email email = client.getAccount().getMailbox().getEmails().get(row);
                email.setNew(false);
                launchReader(email);

            }
        });

        getReadCloseButton().addActionListener(e -> view.getReadWindow().hide());


        getLogOutButton().addActionListener(e -> {
            view.getHomeWindow().hide();
            launchAuth();
        });

        getExitButton().addActionListener(e -> System.exit(0));

        getDeleteButton().addActionListener(e -> {
            int row = getTable().getSelectedRow();
            if (row != -1) {
                TableModelWrapper tableModel = (TableModelWrapper) getTable().getModel();
                tableModel.removeRow(row);
                IRequest request = new DeleteRequest(row);
                client.sendRequest(request);
            }
        });

        getFetchButton().addActionListener(e -> {
            IRequest request = new FetchRequest();
            client.getAccount().setMailbox(new MailBox());
            client.sendRequest(request);
            responseHandler(client.getResponse());
        });

        getNewCloseButton().addActionListener(e -> view.getNewWindow().hide());

        getNewSendButton().addActionListener(e -> {
            Email email = new Email(getSenderText(), getReceiverText(), getSubjectText(), getBodyText());
            IRequest request = new SendEmailRequest(email);
            client.sendRequest(request);
            view.getNewWindow().hide();
        });

        getLoginButton().addActionListener(this);
        getRegisterButton().addActionListener(this);

    }

    public void launchAuth() {
        view.getAuthWindow().show();
    }

    public void launchHome() {
        view.getAuthWindow().hide();
        view.getHomeWindow().show(client.getAccount().getMailbox().getEmails());
    }

    public void launchNew(String sender) {
        if (view.getNewWindow().getFrame().isVisible())
            view.getNewWindow().hide();
        view.getNewWindow().show(sender);
    }

    public void launchReader(Email email) {
        if (view.getReadWindow().getFrame().isVisible())
            view.getReadWindow().hide();
        view.getReadWindow().show(email);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getLoginButton() || e.getSource() == getRegisterButton()) {
            if (!getUserText().equals("") && !getPassText().equals("")) {
                if (e.getSource() == getLoginButton())
                    client.sendRequest(new LoginRequest(getUserText(), getPassText()));
                else
                    client.sendRequest(new RegisterRequest(getUserText(), getPassText()));
                responseHandler(client.getResponse());
            } else
                view.getAuthWindow().getStatusLabel().setText("Incomplete Email or Password");

        }
    }


    private void responseHandler(IResponse response) {
        Type type = response.getType();
        switch (type) {
            case LOGIN -> {
                if (response.getCode() == ResponseCode.SUCCESS) {
                    Account account = ((LoginResponse) response).getAccount();
                    client.setAccount(account);
                    launchHome();
                } else {
                    view.getAuthWindow().getStatusLabel().setText("Invalid Email or Password");
                }

            }
            case REGISTER -> {
                if (response.getCode() == ResponseCode.SUCCESS) {
                    Account account = ((RegisterResponse) response).getAccount();
                    client.setAccount(account);
                    launchHome();
                } else
                    view.getAuthWindow().getStatusLabel().setText("Email already exists");

            }
            case FETCH -> {
                if (response.getCode() == ResponseCode.START) {
                    client.getAccount().setMailbox(new MailBox());
                    IResponse innerResponse = client.getResponse();
                    while(innerResponse.getCode()!=ResponseCode.END){
                        responseHandler(innerResponse);
                        innerResponse = client.getResponse();
                    }
                    view.getHomeWindow().update(client.getAccount().getMailbox().getEmails());
                }
            }
            case EMAIL -> {
                Email email = ((EmailResponse) response).getEmail();
                client.getAccount().getMailbox().addEmail(email);

            }
        }


    }

    private JButton getNewSendButton() {
        return view.getNewWindow().getSendButton();
    }


    public JButton getLoginButton() {
        return view.getAuthWindow().getLoginButton();
    }

    public JButton getRegisterButton() {
        return view.getAuthWindow().getRegisterButton();
    }

    public String getUserText() {
        return view.getAuthWindow().getUserField().getText();
    }

    public String getPassText() {
        return String.valueOf(view.getAuthWindow().getPassField().getPassword());
    }

    public JButton getNewButton() {
        return view.getHomeWindow().getNewButton();
    }

    public JButton getFetchButton() {

        return view.getHomeWindow().getFetchButton();
    }

    public JButton getReadButton() {
        return view.getHomeWindow().getReadButton();
    }

    public JButton getDeleteButton() {
        return view.getHomeWindow().getDeleteButton();
    }

    public JTable getTable() {
        return view.getHomeWindow().getTable();
    }

    public JButton getReadCloseButton() {
        return view.getReadWindow().getCloseButton();
    }


    public JButton getNewCloseButton() {
        return view.getNewWindow().getCloseButton();
    }

    public JButton getLogOutButton() {
        return view.getHomeWindow().getLogOutButton();
    }

    public JButton getExitButton() {
        return view.getHomeWindow().getExitButton();
    }

    public String getSenderText() {
        return view.getNewWindow().getSenderLabel().getText();
    }

    public String getSubjectText() {
        return view.getNewWindow().getSubjectText().getText();
    }

    public String getBodyText() {
        return view.getNewWindow().getBodyText().getText();
    }

    public String getReceiverText() {
        return view.getNewWindow().getReceiverText().getText();
    }
}

