package me.common.code;

import java.io.Serializable;

public class Account implements Serializable {

    private String username;
    private String password;
    private MailBox mailbox;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        mailbox = new MailBox();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MailBox getMailbox() {
        return mailbox;
    }

    public void setMailbox(MailBox mailbox) {
        this.mailbox = mailbox;
    }

}